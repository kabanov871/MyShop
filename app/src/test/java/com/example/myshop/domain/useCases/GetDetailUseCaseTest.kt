package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.utils.createDetailModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetDetailUseCaseTest {

    private val repository = mockk<Repository>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getDetail() = runTest {

        val getDetailUseCase = GetDetailUseCase(
            repository = repository
        )

        coEvery { repository.getDetail() } returns createDetailModel()

        getDetailUseCase.getDetail()

        coVerify(exactly = 1) { repository.getDetail() }

        confirmVerified(repository)

        Assertions.assertEquals(getDetailUseCase.getDetail(), createDetailModel())
    }
}