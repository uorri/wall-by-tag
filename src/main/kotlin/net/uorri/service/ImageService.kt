package net.uorri.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import net.uorri.models.UnsplashImage

class ImageService(
    private val client: HttpClient,
    private val baseUrl: String,
    private val key: String
) {

    suspend fun getImage(query: String): UnsplashImage {
        return client.get(
            """$baseUrl/photos/random?
                |query=$query
                |&orientation=portrait
                |&content_filter=high
                |&order_by=latest
                |&client_id=$key""".trimMargin()
        ).body()
    }

}