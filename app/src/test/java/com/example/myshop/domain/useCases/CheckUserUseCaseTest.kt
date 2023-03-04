package com.example.myshop.domain.useCases

import com.example.myshop.domain.Repository
import io.mockk.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CheckUserUseCaseTest {

    private val repository = mockk<Repository>()

    @Test
    fun checkUser() {

        val checkUserUseCase = CheckUserUseCase(
            repository = repository
        )

        val testString = "test"

        every { repository.checkUser(testString) } returns true

        checkUserUseCase.checkUser(testString)

        verify(exactly = 1) { repository.checkUser(testString) }

        confirmVerified(repository)

        Assertions.assertEquals(checkUserUseCase.checkUser(testString), true)
    }
}