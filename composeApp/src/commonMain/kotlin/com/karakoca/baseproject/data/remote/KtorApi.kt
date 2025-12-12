package com.karakoca.baseproject.data.remote


import KmpBaseProject.composeApp.BuildConfig
import com.karakoca.baseproject.data.local.Constants.BASE_URL
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
internal abstract class KtorApi {

    fun HttpRequestBuilder.pathUrl(path: String) {
        contentType(ContentType.Application.Json)
        url {
            takeFrom(BASE_URL)
            path("3", path)
            parameter("api_key", BuildConfig.API_KEY)
            // headers.append("Authorization", "Bearer ${BuildConfig.API_KEY}")
        }
    }
}