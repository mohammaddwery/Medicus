package com.medicus.app.presentation.base

import androidx.lifecycle.ViewModel
import com.medicus.app.data.data_resource.UiState
import com.medicus.app.data.data_resource.remote_resource.api.ApiException
import com.medicus.app.data.data_resource.remote_resource.api.NetworkConnectionInterceptor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseViewModel : ViewModel() {

    inline fun <T> launchFetchListAsync(
        crossinline execute: suspend () -> List<T>,
    ): Flow<UiState<List<T>>> = flow {
        try {
            emit(UiState.loading())
            val events = execute()
            if(events.isEmpty()) emit(UiState.noResults())
            else emit(UiState.success(events))
        } catch (e: ApiException) {
            emit(UiState.failure(e.error.message))
        } catch (e: NetworkConnectionInterceptor.NoConnectionException) {
            emit(UiState.failure(e.message))
        } catch (e: Exception) {
            emit(UiState.failure("Something_went_wrong"))
        }
    }
}