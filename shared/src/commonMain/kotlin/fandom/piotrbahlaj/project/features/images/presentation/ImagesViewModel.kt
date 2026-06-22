package fandom.piotrbahlaj.project.features.images.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fandom.piotrbahlaj.project.core.utilities.NetworkResult
import fandom.piotrbahlaj.project.features.images.domain.repositories.ImagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ImagesViewModel(
    private val imagesRepository: ImagesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ImagesUiState())
    val state = _state.asStateFlow()

    fun loadImages() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            when (val result = imagesRepository.getImages()) {
                is NetworkResult.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        images = result.data,
                        error = null
                    )
                }

                is NetworkResult.Failure -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.exception.message
                    )
                }
            }
        }
    }
}