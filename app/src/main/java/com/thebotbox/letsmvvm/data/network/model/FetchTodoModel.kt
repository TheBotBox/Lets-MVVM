package com.thebotbox.letsmvvm.data.network.model

import com.google.gson.annotations.SerializedName

data class FetchTodo(
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("completed")
    val completed: Boolean?
)