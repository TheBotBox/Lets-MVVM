package com.thebotbox.letsmvvm.data.repository

import com.thebotbox.letsmvvm.data.db.dao.QuoteDao
import com.thebotbox.letsmvvm.data.db.dao.toQuoteEntity
import com.thebotbox.letsmvvm.data.network.SafeApiRequestWrapper
import com.thebotbox.letsmvvm.data.network.factory.IApiFactory
import com.thebotbox.letsmvvm.data.network.model.FetchTodo
import com.thebotbox.letsmvvm.data.network.model.PostQuoteRequest
import com.thebotbox.letsmvvm.data.network.model.PostQuoteResponse
import com.thebotbox.letsmvvm.data.network.model.RandomQuoteResponse

class Repository(
    private val apiClientFactory: IApiFactory,
    private val dao: QuoteDao
) : IRepository, SafeApiRequestWrapper() {

    override suspend fun fetchRandomQuote(): RandomQuoteResponse {
        return makeSafeRequest { apiClientFactory.client.fetchRandomQuote() }
    }

    override suspend fun uploadQuote(updateQuoteRequest: PostQuoteRequest): PostQuoteResponse {
        return makeSafeRequest { apiClientFactory.client.uploadQuote(updateQuoteRequest) }
    }

    override suspend fun fetchTodo(): FetchTodo {
        return makeSafeRequest { apiClientFactory.clientSecond.fetchToDo() }
    }

    override suspend fun addQuoteToDB(quote: RandomQuoteResponse) {
        dao.addQuote(quote.toQuoteEntity())
    }
}