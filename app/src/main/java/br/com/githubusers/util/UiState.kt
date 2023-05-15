package br.com.githubusers.util

import androidx.annotation.StringRes

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(@StringRes val message: Int) : UiState<Nothing>()
}
