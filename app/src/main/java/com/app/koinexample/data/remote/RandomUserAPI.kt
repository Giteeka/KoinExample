package com.app.koinexample.data.remote

import com.app.koinexample.model.ResultResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//https://randomuser.me/api/1.0/?seed=foobar&results=5

interface RandomUserAPI {

    @GET("api/1.0")
    fun getRandomUser(@Query("seed") seed: String, @Query("results") noOfResults: String):
            Deferred<ResultResponse>

    companion object {

        fun defaultInstance(baseUrl: String): RandomUserAPI {
            val interceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
                .create(RandomUserAPI::class.java)
        }
    }
}