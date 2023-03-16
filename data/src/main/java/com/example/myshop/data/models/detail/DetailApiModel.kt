package com.example.myshop.data.models.detail

data class DetailApiModel(
    val colors: List<String>,
    val description: String,
    val image_urls: List<String>,
    val name: String,
    val number_of_reviews: Int,
    val price: Int,
    val rating: Double
)