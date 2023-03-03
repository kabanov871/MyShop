package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.domain.models.UserModel
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(private val repository: Repository) {

    suspend fun insertUser(model: UserModel) {
        repository.insertUser(model)
    }
}