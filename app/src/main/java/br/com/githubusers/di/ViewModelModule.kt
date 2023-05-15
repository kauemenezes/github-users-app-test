package br.com.githubusers.di

import br.com.githubusers.ui.userdetails.UserDetailsViewModel
import br.com.githubusers.ui.users.UsersViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UsersViewModel(get(), provideMainDispatcher())
    }
    viewModel {
        UserDetailsViewModel(get(), provideMainDispatcher())
    }
}

fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
