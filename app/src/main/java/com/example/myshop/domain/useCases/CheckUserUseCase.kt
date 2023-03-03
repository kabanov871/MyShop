package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import javax.inject.Inject

class CheckUserUseCase @Inject constructor(private val repository: Repository) {

    fun checkUser(firstName: String): Boolean {
        return repository.checkUser(firstName)
    }
}