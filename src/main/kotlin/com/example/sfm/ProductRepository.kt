package com.example.sfm

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ProductRepository : ReactiveMongoRepository<Product, String>