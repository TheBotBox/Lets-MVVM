package com.thebotbox.letsmvvm.data.network.model

import com.google.gson.annotations.SerializedName


data class PostQuoteRequest(
    @SerializedName("quote")
    val quote: String,
    @SerializedName("author")
    val author: String
)

data class PostQuoteResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("quote_id")
    val quote_id: Int?
)