package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.domain.models.DetailModel
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getDetail(): DetailModel {
        return repository.getDetail()
    }
}