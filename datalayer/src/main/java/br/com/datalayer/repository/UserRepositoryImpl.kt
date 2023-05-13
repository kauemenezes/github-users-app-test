package br.com.datalayer.repository

import br.com.datalayer.datasource.UserDataSource
import br.com.domain.model.User
import br.com.domain.model.UserRepo
import br.com.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val dispatcher: CoroutineDispatcher
) : UserRepository {

    override suspend fun getUsers(): Flow<List<User>> {
        return userDataSource.getUsers()
            .flowOn(dispatcher)
    }

    override suspend fun getUser(userLogin: String): Flow<User> {
        return userDataSource.getUser(userLogin)
            .flowOn(dispatcher)
    }

    override suspend fun getUserRepos(userLogin: String): Flow<List<UserRepo>> {
        return userDataSource.getUserRepos(userLogin)
            .flowOn(dispatcher)
    }
}