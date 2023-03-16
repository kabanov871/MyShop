package com.example.myshop.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.myshop.domain.models.UserModel
import com.example.myshop.domain.useCases.CheckUserUseCase
import com.example.myshop.domain.useCases.InsertUserUseCase
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val insertUserUseCase: com.example.myshop.domain.useCases.InsertUserUseCase,
    private val checkUserUseCase: com.example.myshop.domain.useCases.CheckUserUseCase
): ViewModel() {

    fun checkUser(firstName: String): Boolean {
        return checkUserUseCase.checkUser(firstName)
    }

    suspend fun insertUser(model: com.example.myshop.domain.models.UserModel) {
        insertUserUseCase.insertUser(model)
    }
}