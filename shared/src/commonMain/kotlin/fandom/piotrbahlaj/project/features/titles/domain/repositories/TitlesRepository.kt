package fandom.piotrbahlaj.project.features.titles.domain.repositories

import fandom.piotrbahlaj.project.core.utilities.NetworkResult
import fandom.piotrbahlaj.project.features.titles.data.models.Title
import fandom.piotrbahlaj.project.features.titles.data.service.TitlesService

class TitlesRepository(
    private val service: TitlesService
) {
    suspend fun getTitles(): NetworkResult<List<Title>> {
        return try {
            NetworkResult.Success(service.getTitles())
        } catch (e: Exception) {
            NetworkResult.Failure(e)
        }
    }
}