package fandom.piotrbahlaj.project.features.images.data.service

import fandom.piotrbahlaj.project.core.Constants
import fandom.piotrbahlaj.project.core.network.ApiClient
import fandom.piotrbahlaj.project.features.images.data.models.Image

class ImagesService(
    private val apiClient: ApiClient
) {
    suspend fun getImages(): List<Image> {
        return apiClient.get(Constants.TrendingArticlesEndpoint)
    }
}