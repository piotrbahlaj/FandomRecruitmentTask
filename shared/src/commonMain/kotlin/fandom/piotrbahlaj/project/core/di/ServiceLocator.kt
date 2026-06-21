package fandom.piotrbahlaj.project.core.di

import fandom.piotrbahlaj.project.core.config.Environment
import fandom.piotrbahlaj.project.core.network.ApiClient
import fandom.piotrbahlaj.project.core.network.createHttpClient

object ServiceLocator {

    private val httpClient by lazy {
        createHttpClient()
    }

    val apiClient by lazy {
        ApiClient(httpClient, Environment.BASE_URL)
    }
}