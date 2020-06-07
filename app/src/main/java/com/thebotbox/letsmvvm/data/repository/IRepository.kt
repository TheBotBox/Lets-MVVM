package com.thebotbox.letsmvvm.data.repository

import com.thebotbox.letsmvvm.data.network.model.FetchTodo
import com.thebotbox.letsmvvm.data.network.model.PostQuoteRequest
import com.thebotbox.letsmvvm.data.network.model.PostQuoteResponse
import com.thebotbox.letsmvvm.data.network.model.RandomQuoteResponse

interface IRepository {
    suspend fun fetchRandomQuote(): RandomQuoteResponse
    suspend fun uploadQuote(updateQuoteRequest: PostQuoteRequest): PostQuoteResponse
    suspend fun fetchTodo(): FetchTodo

    suspend fun addQuoteToDB(quote: RandomQuoteResponse)
}

