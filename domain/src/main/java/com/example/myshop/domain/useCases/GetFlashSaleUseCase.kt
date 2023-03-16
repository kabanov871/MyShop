package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.domain.models.FlashSaleModel
import javax.inject.Inject

class GetFlashSaleUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getFlashSale(): List<FlashSaleModel> {
        return repository.getFlashSale()
    }
}