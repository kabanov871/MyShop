package com.example.myshop.data.mapper

import com.example.myshop.data.models.detail.DetailApiModel
import com.example.myshop.data.models.user.UserDbModel
import com.example.myshop.data.models.flashSale.FlashSale
import com.example.myshop.data.models.latest.Latest
import com.example.myshop.domain.models.DetailModel
import com.example.myshop.domain.models.FlashSaleModel
import com.example.myshop.domain.models.LatestModel
import com.example.myshop.domain.models.UserModel
import javax.inject.Inject

class Mapper @Inject constructor() {

    private fun mapLatestToLatestModel(model: Latest) = LatestModel(
        category = model.category,
        image_url = model.image_url,
        name = model.name,
        price = model.price
    )

    fun mapListLatestToListLatestModel(list: List<Latest>) = list.map {
        mapLatestToLatestModel(it)
    }

    private fun mapFlashSaleToFlashSaleModel(model: FlashSale) = FlashSaleModel(
        category = model.category,
        discount = model.discount,
        image_url = model.image_url,
        name = model.name,
        price = model.price
    )

    fun mapListFlashSaleToListFlashSaleModel(list: List<FlashSale>) = list.map {
        mapFlashSaleToFlashSaleModel(it)
    }

    fun mapUserModelToUserDbModel(model: UserModel) = UserDbModel(
        id = 0,
        firstName = model.firstName,
        lastName = model.lastName,
        email = model.email
    )

    fun mapDetailApiModelToDetailModel(model: DetailApiModel) = DetailModel(
        colors = model.colors,
        description = model.description,
        image_urls = model.image_urls,
        name = model.name,
        number_of_reviews = model.number_of_reviews,
        price = model.price,
        rating = model.rating
    )
}