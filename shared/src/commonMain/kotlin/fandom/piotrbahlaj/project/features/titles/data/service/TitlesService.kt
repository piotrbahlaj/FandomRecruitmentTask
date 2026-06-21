package fandom.piotrbahlaj.project.features.titles.data.service

import fandom.piotrbahlaj.project.core.network.ApiClient
import fandom.piotrbahlaj.project.features.titles.data.models.Title
import io.ktor.client.call.*
import io.ktor.client.request.*

class TitlesService(
    private val apiClient: ApiClient
) {
    suspend fun getTitles(): List<Title> {
        return apiClient.client
            .get(apiClient.baseUrl)
            .body()
    }
}