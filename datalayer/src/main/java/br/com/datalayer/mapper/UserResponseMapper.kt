package br.com.datalayer.mapper

import br.com.datalayer.model.UserResponse
import br.com.domain.model.User
import br.com.domain.util.Mapper

class UserResponseMapper : Mapper<UserResponse, User?> {

    override fun map(source: UserResponse): User {
        return User(
            id = source.id,
            name = source.name.orEmpty(),
            login = source.login.orEmpty(),
            avatarUrl = source.avatarUrl.orEmpty()
        )
    }
}