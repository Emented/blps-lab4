package emented.sequrity.service

import emented.model.domain.User
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(private val user: User) : UserDetails {

    override fun getAuthorities() = user.roles.map {
        SimpleGrantedAuthority(it.name)
    }

    override fun getPassword() = user.password

    override fun getUsername() = user.username

    fun getUserId() = user.id!!

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}
