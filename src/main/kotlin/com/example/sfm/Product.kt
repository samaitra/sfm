package com.example.sfm

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Product(@Id var id: String? = null, var title: String? = null)