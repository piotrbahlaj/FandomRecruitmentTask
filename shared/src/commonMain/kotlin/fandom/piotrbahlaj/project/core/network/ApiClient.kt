package fandom.piotrbahlaj.project.core.network

import io.ktor.client.*

class ApiClient(
    val client: HttpClient,
    val baseUrl: String
)