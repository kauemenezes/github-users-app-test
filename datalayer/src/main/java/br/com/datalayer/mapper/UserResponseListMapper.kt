package br.com.datalayer.mapper

import br.com.datalayer.model.UserResponse
import br.com.domain.model.User
import br.com.domain.util.Mapper

class UserResponseListMapper :
    Mapper<List<UserResponse>?, List<User>?> {

    private val userResponseMapper = UserResponseMapper()

    override fun map(source: List<UserResponse>?): List<User>? =
        source?.map { userResponseMapper.map(it) }

}