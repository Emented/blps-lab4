package emented.sequrity.service

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.UnsupportedJwtException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.Serializable
import java.util.Date

@Service
class JwtTokenUtil(
    @Value("\${jwt.access.secret}") private val accessTokenSecret: String,
    @Value("\${jwt.refresh.secret}") private val refreshTokenSecret: String,
    @Value("\${jwt.access.validity}") private val accessTokenValidity: Int,
    @Value("\${jwt.refresh.validity}") private val refreshTokenValidity: Int,
) : Serializable {

    fun generateAccessToken(userId: Long, roles: List<String>): String {
        return generateToken(userId, roles, accessTokenSecret, accessTokenValidity)
    }

    fun generateRefreshToken(userId: Long, roles: List<String>): String {
        return generateToken(userId, roles, refreshTokenSecret, refreshTokenValidity)
    }

    private fun generateToken(userId: Long, roles: List<String>, secret: String, validity: Int): String {
        val currentDate = Date()
        return Jwts.builder()
            .setSubject(userId.toString())
            .claim(ROLES_CLAIM_NAME, roles)
            .setIssuedAt(currentDate)
            .setExpiration(Date(currentDate.time + validity))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    fun getInfoFromAccessToken(token: String): Pair<Long, List<String>> {
        return getInfoFromToken(token, accessTokenSecret)
    }

    fun getInfoFromRefreshToken(token: String): Pair<Long, List<String>> {
        return getInfoFromToken(token, refreshTokenSecret)
    }

    private fun getInfoFromToken(token: String, secret: String?): Pair<Long, List<String>> {
        val parsedToken = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)

        return (parsedToken.body.subject.toLong() to parsedToken.body.get(ROLES_CLAIM_NAME, List::class.java)
            .map { it.toString() })
    }

    fun validateAccessToken(token: String): Boolean {
        return validateToken(token, accessTokenSecret)
    }

    fun validateRefreshToken(token: String): Boolean {
        return validateToken(token, refreshTokenSecret)
    }

    private fun validateToken(token: String, secret: String?): Boolean {
        try {
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
            return true
        } catch (e: SignatureException) {
            LOG.error("Invalid signature: {}", e.message)
        } catch (e: MalformedJwtException) {
            LOG.error("Malformed token: {}", e.message)
        } catch (e: ExpiredJwtException) {
            LOG.error("Token expired: {}", e.message)
        } catch (e: UnsupportedJwtException) {
            LOG.error("Unsupported token: {}", e.message)
        } catch (e: IllegalArgumentException) {
            LOG.error("Claims are empty: {}", e.message)
        }
        return false
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(JwtTokenUtil::class.java)

        private const val ROLES_CLAIM_NAME = "roles"
    }
}
