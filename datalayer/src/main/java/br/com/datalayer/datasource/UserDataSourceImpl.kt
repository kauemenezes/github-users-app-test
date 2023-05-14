package br.com.datalayer.datasource

import br.com.datalayer.api.UserService
import br.com.datalayer.mapper.RepoResponseMapper
import br.com.datalayer.mapper.UserResponseMapper
import br.com.domain.model.Repo
import br.com.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserDataSourceImpl(
    private val userService: UserService,
): UserDataSource {

    private val userResponseMapper = UserResponseMapper()
    private val repoResponseMapper = RepoResponseMapper()

    override suspend fun getUsers(): Flow<List<User>> = flow {
        emit(userService.getUsers().map {
            userResponseMapper.map(it)
        })
    }

    override suspend fun getUser(userLogin: String): Flow<User> = flow {
        emit(userResponseMapper.map(userService.getUser(userLogin)))
    }

    override suspend fun getUserRepos(userLogin: String): Flow<List<Repo>> = flow {
        emit(userService.getUserRepos(userLogin).map {
            repoResponseMapper.map(it)
        })
    }
}