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
    fun bindRepository(impl: com.example.myshop.data.repository.RepositoryImpl): com.example.myshop.domain.Repository

    companion object {

        @Provides
        @ApplicationScope
        fun provideUserDao(application: Application): com.example.myshop.data.database.UserDao {
            return com.example.myshop.data.database.ShopDatabase.getInstance(application).userDao
        }

        @Provides
        fun baseUrl() = "https://run.mocky.io/"

        @Provides
        @ApplicationScope
        fun provideRetrofit(baseUrl: String): com.example.myshop.data.network.ApiInterface =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(com.example.myshop.data.network.ApiInterface::class.java)
    }
}