package br.com.sailboat.mobilelabs.android.daggerhilt.impl.data.datasource.remote

import retrofit2.http.GET

interface MyApi {

    @GET("test")
    suspend fun doNetworkCall()
}