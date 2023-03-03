package com.example.myshop.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.domain.models.UserModel
import com.example.myshop.domain.useCases.CheckUserUseCase
import com.example.myshop.domain.useCases.InsertUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase,
    private val checkUserUseCase: CheckUserUseCase
): ViewModel() {

    fun checkUser(firstName: String): Boolean {
        return checkUserUseCase.checkUser(firstName)
    }

    suspend fun insertUser(model: UserModel) {
        insertUserUseCase.insertUser(model)
    }
}