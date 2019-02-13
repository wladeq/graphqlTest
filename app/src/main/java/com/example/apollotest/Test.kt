package com.example.apollotest

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.interceptor.ApolloInterceptor
import com.apollographql.apollo.internal.json.JsonWriter
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okio.Buffer
import okio.ByteString
import java.io.IOException


class Test {
    private var client = OkHttpClient()
    private val HEADER_ACCEPT_TYPE = "Accept"
    private val HEADER_CONTENT_TYPE = "Content-Type"
    private val HEADER_APOLLO_OPERATION_ID = "X-APOLLO-OPERATION-ID"
    private val HEADER_APOLLO_OPERATION_NAME = "X-APOLLO-OPERATION-NAME"
    private val ACCEPT_TYPE = "application/json"
    private val CONTENT_TYPE = "application/json"
    private val MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8")
    private val BASE_URL = "http://172.20.10.25:4000"
    // test data
    internal fun bowlingJson(): String {
        //return ("query{items{name,description}}")
        return ""
    }

    fun fun2():String {
        val requestBody = RequestBody.create(MEDIA_TYPE, httpRequestBody())
        var request = Request.Builder()
                .url(BASE_URL)
                .post(requestBody)
                .header(HEADER_ACCEPT_TYPE, ACCEPT_TYPE)
                .header(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                .header(HEADER_APOLLO_OPERATION_NAME, "")
                .build()

        val response = client.newCall(request).execute()
        return response.body()!!.string()
    }

    @Throws(IOException::class)
    internal fun httpRequestBody(): ByteString {
        val buffer = Buffer()
        val jsonWriter = JsonWriter.of(buffer)
        jsonWriter.serializeNulls = true
        jsonWriter.beginObject()
        jsonWriter.name("operationName").value("")
        jsonWriter.name("variables").beginObject()
        jsonWriter.endObject()
        jsonWriter.name("extensions")
                .beginObject()
                .name("persistedQuery")
                .beginObject()
                .name("version").value(1)
                //.name("sha256Hash").value(operation.operationId())
                .endObject()
                .endObject()
        jsonWriter.name("query").value(bowlingJson().replace("\\n".toRegex(), ""))
        jsonWriter.endObject()
        jsonWriter.close()
        return buffer.readByteString()
    }
}


