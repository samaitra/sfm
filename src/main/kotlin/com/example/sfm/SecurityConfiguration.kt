package com.example.sfm

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User

@Configuration
@EnableWebFluxSecurity
class SecurityConfiguration {


    @Bean
    fun users() = MapReactiveUserDetailsService(User.withDefaultPasswordEncoder()
            .username("admin").password("pwd").roles("ADMIN", "USER").build())

}