package com.example.myshop.di

import android.app.Application
import com.example.myshop.data.database.ShopDatabase
import com.example.myshop.data.database.UserDao
import com.example.myshop.data.network.ApiInterface
import com.example.myshop.data.repository.RepositoryImpl
import com.example.myshop.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {

        @Provides
        @ApplicationScope
        fun provideUserDao(application: Application): UserDao {
            return ShopDatabase.getInstance(application).userDao
        }

        @Provides
        fun baseUrl() = "https://run.mocky.io/"

        @Provides
        @ApplicationScope
        fun provideRetrofit(baseUrl: String): ApiInterface =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
    }
}