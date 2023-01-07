package net.uorri.models

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashImage(val width: Int, val height: Int, val urls: Urls)

@Serializable
data class Urls(val raw: String, val full: String, val regular: String)