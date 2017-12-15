package com.example.sfm

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters.fromObject

import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class WebConfiguration(val ps: ProductService) {

    @Bean
    fun routes() = router {
        GET ("/products", { ServerResponse.ok().body(ps.all(), Product::class.java)})
        GET("/products/{id}", { ServerResponse.ok().body(ps.byId(it.pathVariable("id")), Product::class.java) })
    }
}