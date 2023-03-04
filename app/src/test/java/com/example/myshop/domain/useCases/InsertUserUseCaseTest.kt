package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.utils.createUserModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class InsertUserUseCaseTest {

    private val repository = mockk<Repository>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertUser() = runTest {

        val insertUserUseCase = InsertUserUseCase(
            repository = repository
        )

        coEvery { repository.insertUser(createUserModel()) } just runs

        insertUserUseCase.insertUser(createUserModel())

        coVerify(exactly = 1) { repository.insertUser(createUserModel()) }

        confirmVerified(repository)
    }
}