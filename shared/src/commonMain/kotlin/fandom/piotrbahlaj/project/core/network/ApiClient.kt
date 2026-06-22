package fandom.piotrbahlaj.project.core.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiClient(
    @PublishedApi internal val client: HttpClient,
    val baseUrl: String
) {

    suspend inline fun <reified T> get(path: String): T {
        return client
            .get("$baseUrl$path")
            .body()
    }
}

