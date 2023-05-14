package br.com.githubusers.di

import br.com.domain.usecase.GetUserDetailsUseCase
import br.com.domain.usecase.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetUsersUseCase(get()) }
    single { GetUserDetailsUseCase(get()) }
}