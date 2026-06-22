package fandom.piotrbahlaj.project.features.titles.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fandom.piotrbahlaj.project.core.utilities.NetworkResult
import fandom.piotrbahlaj.project.features.titles.domain.repositories.TitlesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TitlesViewModel(
    private val titlesRepository: TitlesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(TitlesUiState())
    val state = _state.asStateFlow()

    fun loadTitles() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            when (val result = titlesRepository.getTitles()) {
                is NetworkResult.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        titles = result.data,
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