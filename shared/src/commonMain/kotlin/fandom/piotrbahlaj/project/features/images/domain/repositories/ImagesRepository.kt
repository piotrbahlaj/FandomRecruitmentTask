package fandom.piotrbahlaj.project.features.images.domain.repositories

import fandom.piotrbahlaj.project.core.utilities.NetworkResult
import fandom.piotrbahlaj.project.features.images.data.models.Image
import fandom.piotrbahlaj.project.features.images.data.service.ImagesService

class ImagesRepository(
    private val service: ImagesService
) {
    suspend fun getImages(): NetworkResult<List<Image>> {
        return try {
            NetworkResult.Success(service.getImages())
        } catch (e: Exception) {
            NetworkResult.Failure(e)
        }
    }
}