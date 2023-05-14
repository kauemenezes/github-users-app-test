package br.com.githubusers.util

import androidx.annotation.StringRes

sealed class RequestState<out T> {
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(@StringRes val message: Int) : RequestState<Nothing>()
}
