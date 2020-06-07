package com.thebotbox.letsmvvm.data.network

import org.json.JSONObject
import retrofit2.Response
import com.thebotbox.letsmvvm.util.ApiException

abstract class SafeApiRequestWrapper {

    suspend fun <T : Any> makeSafeRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        val b = response.body()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val jsonObject = JSONObject(response.errorBody()?.string())
            val error = jsonObject.getString("error")

            val code = response.code()
            throw ApiException(message = "$error with code $code")
        }
    }
}