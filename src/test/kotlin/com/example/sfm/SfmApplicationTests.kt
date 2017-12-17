package com.example.sfm

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.context.ApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient
import org.junit.Before



@RunWith(SpringRunner::class)
@SpringBootTest
class SfmApplicationTests {

	@Autowired
	val context: ApplicationContext? = null

	private var client: WebTestClient? = null

	@Before
	fun setup() {
		client = WebTestClient
				.bindToApplicationContext(context)
				.configureClient()
				.baseUrl("http://localhost:8080/")
				.build()
	}

	@Test
	fun contextLoads() {
	}

	@Test
	fun getProducts() {
		client!!.get().uri("/products/")
				.exchange()
				.expectStatus()
				.isOk()
	}


}
