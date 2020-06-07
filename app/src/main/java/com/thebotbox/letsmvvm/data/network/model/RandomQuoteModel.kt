package com.thebotbox.letsmvvm.data.network.model

import com.google.gson.annotations.SerializedName


data class RandomQuoteResponse(
    @SerializedName("author")
    val author: String?,
    @SerializedName("quote")
    val quote: String?,
    @SerializedName("quote_id")
    val quote_id: Int?
)