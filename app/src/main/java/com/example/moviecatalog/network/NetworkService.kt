package com.example.moviecatalog.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    fun createHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.build()
    }

    inline fun <reified T> createWebService(
        okHttpClient: OkHttpClient,
        baseUrl: String): T {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()
        return retrofit.create(T::class.java)
    }
}