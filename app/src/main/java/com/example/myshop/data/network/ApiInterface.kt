package com.example.myshop.data.network

import com.example.myshop.data.models.detail.DetailApiModel
import com.example.myshop.data.models.flashSale.FlashSaleApiModel
import com.example.myshop.data.models.latest.LatestApiModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale(): FlashSaleApiModel

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): LatestApiModel

    @GET("v3/f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getDetail(): DetailApiModel
}