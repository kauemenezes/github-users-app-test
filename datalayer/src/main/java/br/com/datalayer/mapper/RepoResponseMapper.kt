package br.com.datalayer.mapper

import br.com.datalayer.model.RepoResponse
import br.com.domain.model.UserRepo
import br.com.domain.util.Mapper

class RepoResponseMapper : Mapper<RepoResponse, UserRepo?> {

    override fun map(source: RepoResponse): UserRepo {
        return UserRepo(
            id = source.id,
            name = source.name.orEmpty(),
            fullName = source.fullName.orEmpty(),
            url = source.url.orEmpty()
        )
    }
}