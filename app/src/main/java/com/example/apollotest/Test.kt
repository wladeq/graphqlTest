package com.example.apollotest

import okhttp3.*
import java.io.IOException


class Test {
    internal var client = OkHttpClient()

    // code request code here
    @Throws(IOException::class)
    internal fun doGetRequest(url: String): String {
        var response: Response? = null
        val request = Request.Builder()
                .url(url)
                .build()
        response = client.newCall(request).execute()


        return response?.body()!!.string()
    }

    // test data
    internal fun bowlingJson(): String {
        return ("query{\n"
                + "feed{\n"
                + "id,\n"
                + "title\n"
                + " }\n"
                + "}\n")
}

    @Throws(IOException::class)
    internal fun doPostRequest(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()
        val response = client.newCall(request).execute()
        return response.body()!!.string()
    }

    @Throws(IOException::class)
    fun fun1() {
        // issue the Get request
        val example = Test()
//        val getResponse = example.doGetRequest("http://localhost:4000")
//        println(getResponse)


        // issue the post request

        val json = example.bowlingJson()
        val postResponse = example.doPostRequest("http://localhost:4000", json)
        println(postResponse)
    }

    companion object {

        // post request code here

        val JSON = MediaType.parse("application/json; charset=utf-8")
    }
}


