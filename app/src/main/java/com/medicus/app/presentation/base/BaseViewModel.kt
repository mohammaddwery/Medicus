package com.medicus.app.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medicus.app.data.data_resource.UiState
import com.medicus.app.data.data_resource.remote_resource.api.ApiException
import com.medicus.app.data.data_resource.remote_resource.api.NetworkConnectionInterceptor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

abstract class BaseViewModel : ViewModel()