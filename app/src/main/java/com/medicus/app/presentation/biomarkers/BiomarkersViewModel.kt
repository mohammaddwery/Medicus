package com.medicus.app.presentation.biomarkers

import androidx.lifecycle.viewModelScope
import com.medicus.app.data.data_resource.UiState
import com.medicus.app.data.data_resource.remote_resource.api.ApiException
import com.medicus.app.data.data_resource.remote_resource.api.NetworkConnectionInterceptor
import com.medicus.app.data.model.Biomarker
import com.medicus.app.data.model.User
import com.medicus.app.data.repository.biomarker.BiomarkerRepository
import com.medicus.app.data.repository.user.UserRepository
import com.medicus.app.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BiomarkersViewModel(
    private val biomarkerRepository: BiomarkerRepository,
    private val userRepository: UserRepository
) : BaseViewModel() {

    private var _biomarkersStateFlow = MutableStateFlow<UiState<List<Biomarker>>>(UiState.loading(null))
    val biomarkersStateFlow: StateFlow<UiState<List<Biomarker>>> = _biomarkersStateFlow

    private var _currentUserStateFlow = MutableStateFlow<User?>(null)
    private val currentUserStateFlow: StateFlow<User?> = _currentUserStateFlow

    init {
        fetchCurrentLocalUser()
        viewModelScope.launch {
            currentUserStateFlow.collectLatest {
                currentUserStateFlow.value?.let {
                    fetchBiomarkers(it.id)
                }
            }
        }
    }

    private fun fetchCurrentLocalUser() = viewModelScope.launch {
        _currentUserStateFlow.value = userRepository.fetchLocalUser()
    }

    private fun fetchBiomarkers(userId: String) = viewModelScope.launch {
        try {
            _biomarkersStateFlow.emit(UiState.loading(oldData = _biomarkersStateFlow.value.data))
            delay(2000)
            val biomarkers = biomarkerRepository.fetchBiomarkers(userId = userId)
            if(biomarkers.isEmpty()) _biomarkersStateFlow.value = UiState.noResults()
            else _biomarkersStateFlow.emit(UiState.success(biomarkers))
        } catch (e: ApiException) {
            _biomarkersStateFlow.emit(UiState.failure(e.error.message))
        } catch (e: NetworkConnectionInterceptor.NoConnectionException) {
            _biomarkersStateFlow.emit(UiState.failure(e.message))
        } catch (e: Exception) {
            _biomarkersStateFlow.emit(UiState.failure("Something_went_wrong"))
        }
    }

    fun refreshBiomarkers() {
        currentUserStateFlow.value?.let {
            fetchBiomarkers(it.id)
        }
    }
}