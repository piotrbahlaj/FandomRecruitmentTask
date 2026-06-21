package fandom.piotrbahlaj.project.features.titles.data.service

import fandom.piotrbahlaj.project.core.Constants
import fandom.piotrbahlaj.project.core.network.ApiClient
import fandom.piotrbahlaj.project.features.titles.data.models.Title

class TitlesService(
    private val apiClient: ApiClient
) {
    suspend fun getTitles(): List<Title> {
        return apiClient.get(Constants.TrendingArticlesEndpoint)
    }
}