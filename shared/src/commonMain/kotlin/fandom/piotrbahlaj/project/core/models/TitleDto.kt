package fandom.piotrbahlaj.project.core.models

import kotlinx.serialization.Serializable

@Serializable
data class TitleDto(
    val title: String,
    val communityName: String,
)
