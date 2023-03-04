package com.example.myshop.utils

import com.example.myshop.data.models.detail.DetailApiModel
import com.example.myshop.data.models.flashSale.FlashSale
import com.example.myshop.data.models.flashSale.FlashSaleApiModel
import com.example.myshop.data.models.latest.Latest
import com.example.myshop.data.models.latest.LatestApiModel
import com.example.myshop.data.models.user.UserDbModel
import com.example.myshop.domain.models.DetailModel
import com.example.myshop.domain.models.FlashSaleModel
import com.example.myshop.domain.models.LatestModel
import com.example.myshop.domain.models.UserModel

fun createDetailApiModel(
    colors: List<String> = listOf("test"),
    description: String = "test",
    image_urls: List<String> = listOf("test"),
    name: String = "test",
    number_of_reviews: Int = 0,
    price: Int = 0,
    rating: Double = 0.0
) = DetailApiModel(
    colors = colors,
    description = description,
    image_urls = image_urls,
    name = name,
    number_of_reviews = number_of_reviews,
    price = price,
    rating = rating
)

fun createFlashSale(
    category: String = "test",
    discount: Int = 0,
    image_url: String = "test",
    name: String = "test",
    price: Double = 0.0
) = FlashSale(
    category = category,
    discount = discount,
    image_url = image_url,
    name = name,
    price = price
)

fun createLatest(
    category: String = "test",
    image_url: String = "test",
    name: String = "test",
    price: Int = 0
) = Latest(
    category = category,
    image_url = image_url,
    name = name,
    price = price
)

fun createUserDbModel(
    id: Int = 0,
    firstName: String = "test",
    lastName: String = "test",
    email: String = "test"
) = UserDbModel(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email
)

fun createDetailModel(
    colors: List<String> = listOf("test"),
    description: String = "test",
    image_urls: List<String> = listOf("test"),
    name: String = "test",
    number_of_reviews: Int = 0,
    price: Int = 0,
    rating: Double = 0.0
) = DetailModel(
    colors = colors,
    description = description,
    image_urls = image_urls,
    name = name,
    number_of_reviews = number_of_reviews,
    price = price,
    rating = rating
)

fun createFlashSaleModel(
    category: String = "test",
    discount: Int = 0,
    image_url: String = "test",
    name: String = "test",
    price: Double = 0.0
) = FlashSaleModel(
    category = category,
    discount = discount,
    image_url = image_url,
    name = name,
    price = price
)

fun createLatestModel(
    category: String = "test",
    image_url: String = "test",
    name: String = "test",
    price: Int = 0
) = LatestModel(
    category = category,
    image_url = image_url,
    name = name,
    price = price
)

fun createUserModel(
    id: Int = 0,
    firstName: String = "test",
    lastName: String = "test",
    email: String = "test"
) = UserModel(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email
)

fun createLatestApiModel(
    latest: List<Latest> = listOf(createLatest())
) = LatestApiModel(
    latest = latest
)

fun createFlashSaleApiModel(
    flashSale: List<FlashSale> = listOf(createFlashSale())
) = FlashSaleApiModel(
    flash_sale = flashSale
)