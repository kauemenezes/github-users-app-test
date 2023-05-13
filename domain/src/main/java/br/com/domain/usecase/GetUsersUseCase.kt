package br.com.domain.usecase

import br.com.domain.repository.UserRepository

class GetUsersUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() =
        userRepository.getUsers()
}