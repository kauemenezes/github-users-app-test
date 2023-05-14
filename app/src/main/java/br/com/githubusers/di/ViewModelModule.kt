package br.com.githubusers.di

import br.com.githubusers.ui.userdetails.UserDetailsViewModel
import br.com.githubusers.ui.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UsersViewModel(get())
    }
    viewModel {
        UserDetailsViewModel(get())
    }
}
