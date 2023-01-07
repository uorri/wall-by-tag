package net.uorri.modules

import com.typesafe.config.ConfigFactory
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.config.*
import kotlinx.serialization.json.Json
import net.uorri.service.ImageService
import org.koin.dsl.module

private val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json {
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
}

private val config = HoconApplicationConfig(ConfigFactory.load())

val unsplashModule = module {
    single {
        ImageService(
            client = client,
            baseUrl = prop("integration.unsplash.baseUrl"),
            key = System.getenv("UNSPLASH_KEY")
        )
    }
}
fun prop(property: String): String = config.property(property).getString()



