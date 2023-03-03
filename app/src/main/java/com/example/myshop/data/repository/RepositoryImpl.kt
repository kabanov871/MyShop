package com.example.myshop.data.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myshop.R
import com.example.myshop.data.database.UserDao
import com.example.myshop.data.mapper.Mapper
import com.example.myshop.data.models.flashSale.FlashSale
import com.example.myshop.data.models.latest.Latest
import com.example.myshop.data.network.ApiInterface
import com.example.myshop.domain.Repository
import com.example.myshop.domain.models.DetailModel
import com.example.myshop.domain.models.FlashSaleModel
import com.example.myshop.domain.models.LatestModel
import com.example.myshop.domain.models.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val mapper: Mapper,
    private val userDao: UserDao
) : Repository {

    override suspend fun getLatest(): List<LatestModel> {
        return mapper.mapListLatestToListLatestModel(apiInterface.getLatest().latest)
    }

    override suspend fun getFlashSale(): List<FlashSaleModel> {
        return mapper.mapListFlashSaleToListFlashSaleModel(apiInterface.getFlashSale().flash_sale)
    }

    override suspend fun insertUser(model: UserModel) {
        userDao.insertUser(mapper.mapUserModelToUserDbModel(model))
    }

    override fun checkUser(firstName: String): Boolean {
        return userDao.checkUser(firstName)
    }

    override suspend fun getDetail(): DetailModel {
        return mapper.mapDetailApiModelToDetailModel(apiInterface.getDetail())
    }

}