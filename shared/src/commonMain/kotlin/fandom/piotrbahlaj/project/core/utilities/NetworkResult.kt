package fandom.piotrbahlaj.project.core.utilities

sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Failure(val exception: Throwable) : NetworkResult<Nothing>()
}