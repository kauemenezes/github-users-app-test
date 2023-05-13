package br.com.datalayer.api

import br.com.datalayer.model.RepoResponse
import br.com.datalayer.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @GET("users/{login}")
    suspend fun getUser(@Path("login") userLogin: String): UserResponse

    @GET("users/{login}/repos")
    suspend fun getUserRepos(@Path("login") userLogin: String): List<RepoResponse>
}