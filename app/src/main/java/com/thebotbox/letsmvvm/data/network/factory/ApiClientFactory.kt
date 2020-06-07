package com.thebotbox.letsmvvm.data.network.factory

import com.thebotbox.letsmvvm.data.network.client.ApiClient
import com.thebotbox.letsmvvm.data.network.client.ApiClientSecond
import retrofit2.Retrofit

class ApiClientFactory(
    private vararg val retrofit: Retrofit
) : IApiFactory {
    override val client: ApiClient
        get() = retrofit[0].create(ApiClient::class.java)

    override val clientSecond: ApiClientSecond
        get() = retrofit[1].create(ApiClientSecond::class.java)
}

