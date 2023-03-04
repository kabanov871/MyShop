package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.utils.createFlashSaleModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetFlashSaleUseCaseTest {

    private val repository = mockk<Repository>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getFlashSale() = runTest {

        val getFlashSaleUseCase = GetFlashSaleUseCase(
            repository = repository
        )

        coEvery { repository.getFlashSale() } returns listOf(createFlashSaleModel())

        getFlashSaleUseCase.getFlashSale()

        coVerify(exactly = 1) { repository.getFlashSale() }

        confirmVerified(repository)

        Assertions.assertEquals(getFlashSaleUseCase.getFlashSale(), listOf(createFlashSaleModel()))
    }
}