package com.example.sfm

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.time.Duration
import java.util.*

@Service
class ProductService (private val pr: ProductRepository) {

    fun all() = pr.findAll()

    fun byId(id: String) = pr.findById(id)

    fun events(id: String) = Flux
    .generate({ sink: SynchronousSink<ProductEvent> -> sink.next(ProductEvent(id, Date())) })
    .delayElements(Duration.ofSeconds(1L))
}