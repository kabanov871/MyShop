package com.example.myshop.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myshop.domain.useCases.GetDetailUseCase
import com.example.myshop.domain.useCases.GetFlashSaleUseCase
import com.example.myshop.domain.useCases.GetLatestUseCase
import com.example.myshop.presentation.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getLatestUseCase: GetLatestUseCase,
    private val getFlashSaleUseCase: GetFlashSaleUseCase,
    private val getDetailUseCase: GetDetailUseCase
): ViewModel() {

    fun getLatest() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getLatestUseCase.getLatest()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getFlashSale() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getFlashSaleUseCase.getFlashSale()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getDetail() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getDetailUseCase.getDetail()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}