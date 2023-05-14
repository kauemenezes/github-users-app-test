package br.com.githubusers.di

import br.com.domain.usecase.GetUserReposUseCase
import br.com.domain.usecase.GetUserUseCase
import br.com.domain.usecase.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetUsersUseCase(get()) }
    single { GetUserUseCase(get()) }
    single { GetUserReposUseCase(get()) }
}