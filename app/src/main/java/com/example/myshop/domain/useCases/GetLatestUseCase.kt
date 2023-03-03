package com.example.myshop.domain.useCases

import com.example.myshop.data.models.latest.Latest
import com.example.myshop.domain.Repository
import com.example.myshop.domain.models.LatestModel
import javax.inject.Inject

class GetLatestUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getLatest(): List<LatestModel> {
        return repository.getLatest()
    }
}