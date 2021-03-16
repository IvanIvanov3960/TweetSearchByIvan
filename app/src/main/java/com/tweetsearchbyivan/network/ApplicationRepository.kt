package com.tweetsearchbyivan.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tweetsearchbyivan.data.PostData
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://api.twitter.com"
private const val BEARER = "Bearer AAAAAAAAAAAAAAAAAAAAAH18NgEAAAAAUeXudxtmrUOLjZ1L8T1vm1KrKDc%3DxTcE1W5YxLFZNEVkiJfXUIj71mEWneTzfnPNDeM9LxSuLYYkJ1"
private const val MAX_RESULTS = 100

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ApplicationRepository {
    @Headers( "Content-Type: application/json;charset=UTF-8")
    @GET("2/tweets/search/recent?")
    fun searchTweet(@Header("Authorization") token: String, @Query("query") keyword: String,
                    @Query("max_results") max: Int = MAX_RESULTS): Deferred<PostData>

}


object ApplicationApi {
    fun getBearer(): String {
    return BEARER
    }

    val retrofitService : ApplicationRepository by lazy {
        retrofit.create(ApplicationRepository::class.java)
    }
}