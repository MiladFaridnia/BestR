package com.faridnia.bestr.presentaion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faridnia.bestr.domain.use_case.GoogleDirectionsUseCase
import com.faridnia.bestr.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GoogleDirectionsViewModel @Inject constructor(private val useCase: GoogleDirectionsUseCase) :
    ViewModel() {


    val state by mutableStateOf(DirectionState())

    fun getDirection(
        start: String,
        destination: String,
        key: String
    ) {
        viewModelScope.launch {
            useCase(
                start,
                destination,
                key
            ).onEach { responseResource ->
                when (responseResource) {
                    is Resource.Success -> handleSuccess()
                    is Resource.Error -> handleError()
                    is Resource.Loading -> handleLoading(true)
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun handleSuccess() {

    }

    private fun handleError() {

    }

    private fun handleLoading(isLoading: Boolean) {

    }
}