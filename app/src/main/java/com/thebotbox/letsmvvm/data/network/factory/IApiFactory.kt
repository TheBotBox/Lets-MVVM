package com.thebotbox.letsmvvm.data.network.factory

import com.thebotbox.letsmvvm.data.network.client.ApiClient
import com.thebotbox.letsmvvm.data.network.client.ApiClientSecond


interface IApiFactory {
    val client: ApiClient
    val clientSecond: ApiClientSecond
}