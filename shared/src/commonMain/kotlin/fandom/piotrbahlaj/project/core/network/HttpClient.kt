package fandom.piotrbahlaj.project.core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun createHttpClient(): HttpClient