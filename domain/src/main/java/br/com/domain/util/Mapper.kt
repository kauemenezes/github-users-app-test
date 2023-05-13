package br.com.domain.util

interface Mapper<S, T> {
    fun map(source: S): T
}