package ru.anb.fitnesskit.api

sealed class ApiResult<out T>(
    val data: T?,
    val errorMessage: String?
) {

    class Success<out T>(_data: T?) : ApiResult<T>(
        data = _data,
        errorMessage = null
    )

    class Error<out T>(
        val exception: String
    ) : ApiResult<T>(
        data = null,
        errorMessage = exception
    )
}
