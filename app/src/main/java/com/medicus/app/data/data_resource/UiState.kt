package com.medicus.app.data.data_resource

import com.medicus.app.core.UiStateStatus

data class UiState<T>(
    val status: UiStateStatus,
    val data : T?=null,
    val message: String?=null
) {

    companion object{
        fun <T> success(data: T): UiState<T> = UiState(
                status = UiStateStatus.SUCCESS,
                data = data,
            )

        fun <T> noResults(): UiState<T> =
            UiState(status = UiStateStatus.NO_RESULTS)

        fun <T> loading(oldData: T?): UiState<T> =
            UiState(
                status = UiStateStatus.LOADING,
                data = oldData,
                )

        fun <T> failure(message: String?): UiState<T> = UiState(
                status = UiStateStatus.FAILURE,
                message = message,
            )
    }
}
