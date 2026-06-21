package fandom.piotrbahlaj.project.features.images.presentation

import fandom.piotrbahlaj.project.features.images.data.models.Image

data class ImagesUiState(
    val isLoading: Boolean = false,
    val images: List<Image> = emptyList(),
    val error: String? = null
)