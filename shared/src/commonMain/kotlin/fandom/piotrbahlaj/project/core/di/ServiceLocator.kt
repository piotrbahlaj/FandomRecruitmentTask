package fandom.piotrbahlaj.project.core.di

import fandom.piotrbahlaj.project.core.config.Environment
import fandom.piotrbahlaj.project.core.network.ApiClient
import fandom.piotrbahlaj.project.core.network.createHttpClient
import fandom.piotrbahlaj.project.features.images.data.service.ImagesService
import fandom.piotrbahlaj.project.features.images.domain.repositories.ImagesRepository
import fandom.piotrbahlaj.project.features.images.presentation.ImagesViewModel
import fandom.piotrbahlaj.project.features.titles.data.service.TitlesService
import fandom.piotrbahlaj.project.features.titles.domain.repositories.TitlesRepository
import fandom.piotrbahlaj.project.features.titles.presentation.TitlesViewModel

object ServiceLocator {

    // NETWORK
    private val httpClient by lazy {
        createHttpClient()
    }

    val apiClient by lazy {
        ApiClient(httpClient, Environment.BASE_URL)
    }

    // SERVICES
    val imagesService by lazy {
        ImagesService(apiClient)
    }

    val titlesService by lazy {
        TitlesService(apiClient)
    }

    // REPOSITORIES
    val imagesRepository by lazy {
        ImagesRepository(imagesService)
    }

    val titlesRepository by lazy {
        TitlesRepository(titlesService)
    }

    // VIEW MODELS
    val imagesViewModel by lazy {
        ImagesViewModel(imagesRepository)
    }

    val titlesViewModel by lazy {
        TitlesViewModel(titlesRepository)
    }
}