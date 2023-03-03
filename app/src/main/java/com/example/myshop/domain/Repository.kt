package com.example.myshop.domain

import com.example.myshop.domain.models.DetailModel
import com.example.myshop.domain.models.FlashSaleModel
import com.example.myshop.domain.models.LatestModel
import com.example.myshop.domain.models.UserModel

interface Repository {

    suspend fun getLatest(): List<LatestModel>

    suspend fun getFlashSale(): List<FlashSaleModel>

    suspend fun insertUser(model: UserModel)

    fun checkUser(firstName: String): Boolean

    suspend fun getDetail(): DetailModel
}