package br.com.githubusers.source

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.datalayer.api.UserService
import br.com.datalayer.datasource.UserDataSource
import br.com.datalayer.datasource.UserDataSourceImpl
import br.com.githubusers.sample.userReposResponse
import br.com.githubusers.sample.userResponse
import br.com.githubusers.sample.usersResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDataSourceTest {

    private lateinit var userDataSource: UserDataSource
    private var mockkUserService = mockk<UserService>()

    @Before
    fun setup() {
        userDataSource = UserDataSourceImpl(mockkUserService)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUsers_confirmObtained() = runBlocking {
        coEvery { mockkUserService.getUsers() } returns usersResponse
        userDataSource.getUsers().take(1).collect {
            Assert.assertEquals(3, it.size)
            Assert.assertEquals("test1", it[0].login)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUser_confirmObtained() = runBlocking {
        coEvery { mockkUserService.getUser("test1") } returns userResponse
        userDataSource.getUser("test1").take(1).collect {
            Assert.assertEquals("test 1" , it.name)
            Assert.assertEquals("test1", it.login)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRepos_confirmObtained() = runBlocking {
        coEvery { mockkUserService.getUserRepos("test1") } returns userReposResponse
        userDataSource.getUserRepos("test1").take(1).collect {
            Assert.assertEquals(3, it.size)
            Assert.assertEquals("repo1", it[0].name)
        }
    }
}