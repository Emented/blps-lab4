package emented.sequrity.service

import emented.dao.UserDao
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService(private val userDao: UserDao) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userDao.getByUsername(username) ?: throw UsernameNotFoundException("User not found")
        return UserDetailsImpl(user)
    }
}
