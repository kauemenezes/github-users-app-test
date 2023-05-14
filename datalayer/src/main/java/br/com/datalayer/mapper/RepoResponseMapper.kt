package br.com.datalayer.mapper

import br.com.datalayer.model.RepoResponse
import br.com.domain.model.Repo
import br.com.domain.util.Mapper

class RepoResponseMapper : Mapper<RepoResponse, Repo?> {

    override fun map(source: RepoResponse): Repo {
        return Repo(
            id = source.id,
            name = source.name.orEmpty(),
            fullName = source.fullName.orEmpty(),
            url = source.url.orEmpty()
        )
    }
}