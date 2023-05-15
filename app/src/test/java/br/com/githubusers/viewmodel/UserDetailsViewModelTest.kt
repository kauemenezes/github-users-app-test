package br.com.githubusers.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import br.com.domain.usecase.GetUserDetailsUseCase
import br.com.githubusers.sample.userRepos
import br.com.githubusers.ui.userdetails.UserDetailsViewModel
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
class UserDetailsViewModelTest {

    private var mockkGetUserDetailsUseCase = mockk<GetUserDetailsUseCase>()

    @Test
    fun getUserDetails_confirmObtained() {
        runTest {
            coEvery { mockkGetUserDetailsUseCase("test1") } returns flowOf(userRepos)
            val viewModel =
                UserDetailsViewModel(mockkGetUserDetailsUseCase, UnconfinedTestDispatcher())
            viewModel.getUserDetails("test1")
            viewModel.userDetails.test {
                Assert.assertEquals(RequestState.Success(userRepos), awaitItem())
                cancelAndIgnoreRemainingEvents()
            }
            coVerify { mockkGetUserDetailsUseCase("test1") }
        }
    }
}