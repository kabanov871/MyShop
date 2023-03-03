package com.example.myshop.domain.models

data class FlashSaleModel(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)
