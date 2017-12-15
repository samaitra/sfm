package com.example.sfm

import org.springframework.stereotype.Service

@Service
class ProductService (private val pr: ProductRepository) {

    fun all() = pr.findAll()

    fun byId(id: String) = pr.findById(id)
}