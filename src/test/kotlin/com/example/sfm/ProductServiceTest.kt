package com.example.sfm

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import reactor.test.StepVerifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Duration

@RunWith(SpringRunner::class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    var productService: ProductService? = null

    @Test
    @Throws(Exception::class)
    fun eventsTake10() {
        val product = productService!!.all().blockFirst()

        StepVerifier.withVirtualTime {
            this.productService!!.events(product.id!!)
                    .take(10)
                    .collectList()
        }
                .thenAwait(Duration.ofHours(1))
                .consumeNextWith({ list -> assertTrue(list.size == 10) })
                .verifyComplete()
    }
}