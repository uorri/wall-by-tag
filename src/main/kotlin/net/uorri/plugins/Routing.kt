package net.uorri.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.uorri.service.ImageService
import org.koin.ktor.ext.inject
import java.net.URL

fun Application.configureRouting() {

    val imageService: ImageService by inject()

    routing {
        get("/img") {
            with(call.request.queryParameters) {
                val image = imageService.getImage(this["query"] ?: "")
                call.respondBytes(URL(image.urls.full).readBytes())
            }
        }
    }

}

