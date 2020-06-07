package com.thebotbox.letsmvvm.data.network.client

import com.thebotbox.letsmvvm.data.network.model.FetchTodo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClientSecond {
    @GET("/todos/1")
    suspend fun fetchToDo(): Response<FetchTodo>
}