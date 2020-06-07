package com.thebotbox.letsmvvm.data.network.client

import com.thebotbox.letsmvvm.data.network.model.RandomQuoteResponse
import com.thebotbox.letsmvvm.data.network.model.PostQuoteRequest
import com.thebotbox.letsmvvm.data.network.model.PostQuoteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @GET("get-random-quote")
    suspend fun fetchRandomQuote(): Response<RandomQuoteResponse>

    @POST("create-quote")
    suspend fun uploadQuote(@Body updateQuoteRequest: PostQuoteRequest): Response<PostQuoteResponse>

}