package fandom.piotrbahlaj.project.features.images.data.service

import fandom.piotrbahlaj.project.core.network.ApiClient
import fandom.piotrbahlaj.project.features.images.data.models.Image
import io.ktor.client.call.*
import io.ktor.client.request.*

class ImagesService(
    private val apiClient: ApiClient
) {
    suspend fun getImages(): List<Image> {
        return apiClient.client
            .get(apiClient.baseUrl)
            .body()
    }
}