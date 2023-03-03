package com.example.myshop.domain

import androidx.lifecycle.LiveData
import com.example.myshop.data.models.latest.Latest
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