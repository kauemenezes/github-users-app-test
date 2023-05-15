package br.com.githubusers.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.datalayer.api.UserService
import br.com.datalayer.datasource.UserDataSource
import br.com.datalayer.datasource.UserDataSourceImpl
import br.com.datalayer.repository.UserRepositoryImpl
import br.com.domain.repository.UserRepository
import br.com.githubusers.sample.userReposResponse
import br.com.githubusers.sample.userResponse
import br.com.githubusers.sample.usersResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class UserRepositoryTest {

    private lateinit var userDataSource: UserDataSource
    private lateinit var userRepository: UserRepository
    private var mockkUserService = mockk<UserService>()

    @Before
    fun setup() {
        userDataSource = UserDataSourceImpl(mockkUserService)
        userRepository = UserRepositoryImpl(userDataSource, UnconfinedTestDispatcher())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUsers_confirmObtained() = runBlocking {
        coEvery { mockkUserService.getUsers() } returns usersResponse
        userRepository.getUsers().take(1).collect {
            Assert.assertEquals(3, it.size)
            Assert.assertEquals("test1", it[0].login)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUserDetails_confirmObtained() = runBlocking {
        coEvery { mockkUserService.getUser("test1") } returns userResponse
        coEvery { mockkUserService.getUserRepos("test1") } returns userReposResponse
        userRepository.getUserDetails("test1").take(1).collect {
            Assert.assertEquals("test1", it.user.login)
            Assert.assertEquals(3, it.userRepos.size)
        }
    }
}