package br.com.domain.usecase

import br.com.domain.repository.UserRepository

class GetUserReposUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userLogin: String) =
        userRepository.getUserRepos(userLogin)
}