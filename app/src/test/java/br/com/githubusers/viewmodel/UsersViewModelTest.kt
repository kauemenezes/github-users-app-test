package br.com.githubusers.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import br.com.domain.usecase.GetUsersUseCase
import br.com.githubusers.sample.users
import br.com.githubusers.ui.users.UsersViewModel
import br.com.githubusers.util.RequestState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class UsersViewModelTest {

    private var mockkGetUsersUseCase = mockk<GetUsersUseCase>()

    @Test
    fun getUsers_confirmObtained() {
        runTest {
            coEvery { mockkGetUsersUseCase() } returns flowOf(users)
            val viewModel =
                UsersViewModel(mockkGetUsersUseCase, UnconfinedTestDispatcher())
            viewModel.users.test {
                Assert.assertEquals(RequestState.Success(users), awaitItem())
                cancelAndIgnoreRemainingEvents()
            }
            coVerify { mockkGetUsersUseCase() }
        }
    }
}