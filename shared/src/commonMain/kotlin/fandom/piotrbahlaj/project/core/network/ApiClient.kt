package fandom.piotrbahlaj.project.core.network

import io.ktor.client.HttpClient

class ApiClient(
    private val client: HttpClient,
    private val baseUrl: String
)