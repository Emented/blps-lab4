package emented.sequrity

import emented.sequrity.service.JwtAuthenticationEntryPoint
import emented.sequrity.service.JwtRequestFilter
import emented.sequrity.service.JwtUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true,
)
class SequrityConfig(
    private val userDetailsService: JwtUserDetailsService,
    private val authenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val requestFilter: JwtRequestFilter,
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity
            .cors {
                it.configurationSource {
                    val corsConfiguration = CorsConfiguration().applyPermitDefaultValues()
                    corsConfiguration.allowedOrigins = listOf("http://localhost:3000")
                    corsConfiguration.addAllowedMethod(HttpMethod.DELETE)
                    corsConfiguration
                }
            }
            .csrf {
                it.disable()
            }
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/login",
                    "/register",
                    "/refresh",
                    "/ping",
                    "/v3/api-docs/**",
                    "/v3/api-docs**",
                    "/swagger-ui**",
                    "/swagger-ui/**",
                ).permitAll().anyRequest().authenticated()
            }
            .exceptionHandling {
                it.authenticationEntryPoint(authenticationEntryPoint)
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
        httpSecurity.authenticationProvider(authenticationProvider())
        httpSecurity.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter::class.java)

        return httpSecurity.build()
    }
}
