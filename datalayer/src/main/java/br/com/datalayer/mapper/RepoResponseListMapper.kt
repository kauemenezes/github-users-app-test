package br.com.datalayer.mapper

import br.com.datalayer.model.RepoResponse
import br.com.domain.model.UserRepo
import br.com.domain.util.Mapper

class RepoResponseListMapper :
    Mapper<List<RepoResponse>?, List<UserRepo>?> {

    private val repoResponseMapper = RepoResponseMapper()

    override fun map(source: List<RepoResponse>?): List<UserRepo>? =
        source?.map { repoResponseMapper.map(it) }

}