package net.uorri

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.uorri.modules.unsplashModule
import net.uorri.plugins.configureRouting
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(unsplashModule)
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}
