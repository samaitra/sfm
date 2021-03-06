package com.example.sfm

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux

@SpringBootApplication
class SfmApplication {
    @Bean
    fun runner(pr: ProductRepository) = ApplicationRunner {
        pr.deleteAll()
                .thenMany(Flux.just("Hatchimals", "Rubik Cube", "Lego")
                        .flatMap { pr.save(Product(title = it)) })
                .thenMany(pr.findAll())
                .subscribe( {println(it)})
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SfmApplication::class.java, *args)
}




