package fandom.piotrbahlaj.project.features.titles.presentation

import fandom.piotrbahlaj.project.features.titles.data.models.Title

data class TitlesUiState(
    val isLoading: Boolean = false,
    val titles: List<Title> = emptyList(),
    val error: String? = null
)
