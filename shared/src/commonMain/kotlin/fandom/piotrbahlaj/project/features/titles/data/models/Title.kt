package fandom.piotrbahlaj.project.features.titles.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Title(
    val title: String,
    val communityName: String,
)