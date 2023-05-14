package br.com.githubusers.util

import br.com.githubusers.R
import java.io.IOException

object ExceptionParser {

    fun getMessage(exception: Throwable): Int {
        return when (exception) {
            is IOException -> R.string.error_no_connection
            else -> generalError()
        }
    }

    private fun generalError() = R.string.error_something_went_wrong
}