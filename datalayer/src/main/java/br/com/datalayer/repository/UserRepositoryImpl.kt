package br.com.datalayer.repository

import br.com.datalayer.datasource.UserDataSource
import br.com.domain.model.User
import br.com.domain.model.UserRepo
import br.com.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val dispatcher: CoroutineDispatcher
) : UserRepository {

    override suspend fun getUsers(): Flow<List<User>> {
        return userDataSource.getUsers()
            .flowOn(dispatcher)
    }

    override suspend fun getUserDetails(userLogin: String): Flow<UserRepo> {
        return userDataSource.getUser(userLogin)
            .zip(userDataSource.getUserRepos(userLogin)) { userDetails, userRepos ->
                return@zip UserRepo(
                    user = userDetails,
                    userRepos = userRepos
                )
            }
            .flowOn(dispatcher)
    }
}