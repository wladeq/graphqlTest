package com.example.apollotest

import com.apollographql.apollo.internal.json.JsonWriter
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okio.Buffer
import okio.ByteString


class RequestHandler {
    private var client = OkHttpClient()
    private val HEADER_ACCEPT_TYPE = "Accept"
    private val HEADER_CONTENT_TYPE = "Content-Type"
    private val ACCEPT_TYPE = "application/json"
    private val CONTENT_TYPE = "application/json"
    private val MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8")
    private val BASE_URL = "https://eu1.prisma.sh/jaroslavi-b7c2e1/apollo/dev"

    private fun jsonBody(): String {
        return ("query{\n"
                + "links{\n"
                + "id\n"
                + " }\n"
                + "}\n")
    }

    fun makeRequest(): String {
        val requestBody = RequestBody.create(MEDIA_TYPE, httpRequestBody())
        var request = Request.Builder()
                .url(BASE_URL)
                .post(requestBody)
                .header(HEADER_ACCEPT_TYPE, ACCEPT_TYPE)
                .header(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                .build()

        val response = client.newCall(request).execute()
        return response.body()!!.string()
    }

    //Ten jsonWriter jest zrobiony tak samo, jak to robi Apollo w klasie:
    // "ApolloServerInterceptor.java" - na końcu jest metoda httpRequestBody

    private fun httpRequestBody(): ByteString {
        val buffer = Buffer()
        val jsonWriter = JsonWriter.of(buffer)
        jsonWriter.serializeNulls = true
        jsonWriter.beginObject()
        jsonWriter.name("variables").beginObject()
        jsonWriter.endObject()
        jsonWriter.name("extensions")
                .beginObject()
                .name("persistedQuery")
                .beginObject()
                .name("version").value(1)
                .endObject()
                .endObject()
        jsonWriter.name("query").value(jsonBody().replace("\\n".toRegex(), ""))
        jsonWriter.endObject()
        jsonWriter.close()
        return buffer.readByteString()
    }
}


