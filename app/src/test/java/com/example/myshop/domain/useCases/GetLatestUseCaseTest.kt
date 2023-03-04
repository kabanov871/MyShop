package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import com.example.myshop.utils.createLatestModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetLatestUseCaseTest {

    private val repository = mockk<Repository>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getLatest() = runTest {

        val getLatestUseCase = GetLatestUseCase(
            repository = repository
        )

        coEvery { repository.getLatest() } returns listOf(createLatestModel())

        getLatestUseCase.getLatest()

        coVerify(exactly = 1) { repository.getLatest() }

        confirmVerified(repository)

        Assertions.assertEquals(getLatestUseCase.getLatest(), listOf(createLatestModel()))
    }
}