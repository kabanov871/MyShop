package com.example.myshop.presentation.viewModels

import com.example.myshop.domain.useCases.CheckUserUseCase
import com.example.myshop.domain.useCases.InsertUserUseCase
import com.example.myshop.utils.createUserModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserViewModelTest {

    private val insertUserUseCase = mockk<InsertUserUseCase>()
    private val checkUserUseCase = mockk<CheckUserUseCase>()

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @Test
    fun checkUser() {

        val userViewModel = UserViewModel(
            insertUserUseCase = insertUserUseCase,
            checkUserUseCase = checkUserUseCase
        )

        val testString = "test"

        every { checkUserUseCase.checkUser(testString) } returns true

        userViewModel.checkUser(testString)

        verify(exactly = 1) { checkUserUseCase.checkUser(testString) }

        confirmVerified(insertUserUseCase, checkUserUseCase)

        Assertions.assertEquals(userViewModel.checkUser(testString), true)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertUser() = runTest {

        val userViewModel = UserViewModel(
            insertUserUseCase = insertUserUseCase,
            checkUserUseCase = checkUserUseCase
        )

        coEvery { insertUserUseCase.insertUser(createUserModel()) } just runs

        userViewModel.insertUser(createUserModel())

        coVerify(exactly = 1) { insertUserUseCase.insertUser(createUserModel()) }

        confirmVerified(insertUserUseCase, checkUserUseCase)
    }
}