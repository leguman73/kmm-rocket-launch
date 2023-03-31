package com.example.myfirstkmpapp

import RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RocketStorage {
    private val httpClient = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    private val fileName = "rocket_launches"

    @Throws(Exception::class)
    suspend fun storeRockets(context: Any?) {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val fileWriter = FileWriter(fileName, context)
        fileWriter.write(rockets.toString())
    }

    @Throws(Exception::class)
    fun readRockets(context: Any?): String {
        return FileReader(fileName, context).read()
    }
}