package com.example.myshop.data.repository

import com.example.myshop.data.database.UserDao
import com.example.myshop.data.mapper.Mapper
import com.example.myshop.data.network.ApiInterface
import com.example.myshop.utils.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions

class RepositoryImplTest {

    private val apiInterface = mockk<ApiInterface>()
    private val mapper = mockk<Mapper>()
    private val userDao = mockk<UserDao>()

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getLatest() = runTest {

        val repositoryImpl = RepositoryImpl(
            apiInterface = apiInterface,
            mapper = mapper,
            userDao = userDao
        )

        coEvery { apiInterface.getLatest() } returns createLatestApiModel()

        coEvery {
            mapper.mapListLatestToListLatestModel(createLatestApiModel().latest)
        } returns listOf(createLatestModel())

        repositoryImpl.getLatest()

        coVerify(exactly = 1) {
            apiInterface.getLatest()
            mapper.mapListLatestToListLatestModel(createLatestApiModel().latest)
        }

        confirmVerified(apiInterface, mapper,userDao)

        Assertions.assertEquals(repositoryImpl.getLatest(), listOf(createLatestModel()))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getFlashSale() = runTest {

        val repositoryImpl = RepositoryImpl(
            apiInterface = apiInterface,
            mapper = mapper,
            userDao = userDao
        )

        coEvery { apiInterface.getFlashSale() } returns createFlashSaleApiModel()

        coEvery {
            mapper.mapListFlashSaleToListFlashSaleModel(createFlashSaleApiModel().flash_sale)
        } returns listOf(createFlashSaleModel())

        repositoryImpl.getFlashSale()

        coVerify(exactly = 1) {
            apiInterface.getFlashSale()
            mapper.mapListFlashSaleToListFlashSaleModel(createFlashSaleApiModel().flash_sale)
        }

        confirmVerified(apiInterface, mapper,userDao)

        Assertions.assertEquals(repositoryImpl.getFlashSale(), listOf(createFlashSaleModel()))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertUser() = runTest {

        val repositoryImpl = RepositoryImpl(
            apiInterface = apiInterface,
            mapper = mapper,
            userDao = userDao
        )

        coEvery { mapper.mapUserModelToUserDbModel(createUserModel()) } returns createUserDbModel()

        coEvery { userDao.insertUser(createUserDbModel()) } just runs

        repositoryImpl.insertUser(createUserModel())

        coVerify(exactly = 1) {
            mapper.mapUserModelToUserDbModel(createUserModel())
            userDao.insertUser(createUserDbModel())
        }

        confirmVerified(apiInterface, mapper,userDao)
    }

    @Test
    fun checkUser() {

        val repositoryImpl = RepositoryImpl(
            apiInterface = apiInterface,
            mapper = mapper,
            userDao = userDao
        )

        val testString = "test"

        every { userDao.checkUser(testString) }  returns  true

        repositoryImpl.checkUser(testString)

        verify(exactly = 1) { userDao.checkUser(testString) }

        confirmVerified(apiInterface, mapper,userDao)

        Assertions.assertEquals(repositoryImpl.checkUser(testString), true)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getDetail() = runTest {

        val repositoryImpl = RepositoryImpl(
            apiInterface = apiInterface,
            mapper = mapper,
            userDao = userDao
        )

        coEvery { apiInterface.getDetail() } returns createDetailApiModel()

        coEvery {
            mapper.mapDetailApiModelToDetailModel(createDetailApiModel())
        } returns createDetailModel()

        repositoryImpl.getDetail()

        coVerify(exactly = 1) {
            apiInterface.getDetail()
            mapper.mapDetailApiModelToDetailModel(createDetailApiModel())
        }

        confirmVerified(apiInterface, mapper,userDao)

        Assertions.assertEquals(repositoryImpl.getDetail(), createDetailModel())
    }
}