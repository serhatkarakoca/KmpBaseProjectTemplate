package com.karakoca.baseproject.di

import com.karakoca.baseproject.data.local.AppPreferencesRepository
import com.karakoca.baseproject.data.local.database.MovieDao
import com.karakoca.baseproject.data.local.database.MovieDatabase
import com.karakoca.baseproject.data.remote.ApiService
import com.karakoca.baseproject.data.remote.RemoteDataSource
import com.karakoca.baseproject.data.repository.MovieRepositoryImpl
import com.karakoca.baseproject.domain.repository.MovieRepository
import com.karakoca.baseproject.domain.usecase.GetMoviesUseCase
import com.karakoca.baseproject.platform.chuckerProvider
import com.karakoca.baseproject.platform.getDatastoreModuleByPlatform
import com.karakoca.baseproject.platform.getRoomDatabase
import com.karakoca.baseproject.platform.provideDispatcher
import com.karakoca.baseproject.presentation.favorite.FavoriteViewModel
import com.karakoca.baseproject.presentation.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val dataModule = module {
    single { RemoteDataSource(get(), get()) }
    single { ApiService(get()) }
}

val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }

    //useCases
    factory { GetMoviesUseCase() }


    //viewModels
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { FavoriteViewModel(get()) }
}

val platformModule = module {
    factory { provideDispatcher() }
    single<MovieDatabase> { getRoomDatabase() }
    single<MovieDao> { get<MovieDatabase>().getDao() }
}

val networkModule = module {
    single<HttpClient> { provideHttpClient(get()) }
}

fun provideHttpClient(prefs: AppPreferencesRepository): HttpClient {
    val chuckerInterceptor = chuckerProvider().getOkhttpEngine()
    val httpClient =
        if (chuckerInterceptor != null) HttpClient(chuckerInterceptor) else HttpClient()

    return httpClient.config {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
                prettyPrint = true
                isLenient = true
                explicitNulls = false
            })

        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }

        /*install(Auth) {
            bearer {
                refreshTokens {
                    val body = client.post {
                        markAsRefreshTokenRequest()
                        url(BASE_URL)
                        parameter("client_id", BuildConfig.CLIENT_ID)
                        parameter("client_secret", BuildConfig.CLIENT_SECRET)
                        parameter("grant_type", BuildConfig.GRANT_TYPE)
                    }.body<UserCredentials>()

                    prefs.setAccessToken(body.accessToken ?: "")

                    BearerTokens(
                        accessToken = body.accessToken ?: "",
                        refreshToken = body.accessToken
                    )
                }

            }
        }*/
    }
}

private val sharedModules = listOf(dataModule, domainModule, platformModule, networkModule)

fun getSharedModules() = sharedModules + getDatastoreModuleByPlatform()