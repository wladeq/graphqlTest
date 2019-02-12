package com.example.apollotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloCallback
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.example.apollotest.type.FeedType
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
//    fun ApolloClient(): ApolloClient? {
//        return apolloClient
//    }
    private var apolloClient: ApolloClient? = null
    internal var githuntFeedCall: ApolloCall<TestQuery.Data>? = null
    internal var uiHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val okHttpClient = OkHttpClient.Builder()
                .build()
        val FEED_SIZE = 20

        val dataCallback = ApolloCallback(object : ApolloCall.Callback<TestQuery.Data>() {
            override fun onResponse(response: Response<TestQuery.Data>) {
                print("Norm - ")
            }

            override fun onFailure(e: ApolloException) {
               print("Nie norm - ")
            }
        }, uiHandler)


        apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                //.subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory(SUBSCRIPTION_BASE_URL, okHttpClient))
                .build()

        var apolloClientCopy = apolloClient

        val feedQuery: TestQuery = TestQuery.builder()
                .limit(FEED_SIZE)
                .type(FeedType.HOT)
                .build()

        githuntFeedCall = apolloClientCopy?.query(feedQuery)
                ?.responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
        githuntFeedCall?.enqueue(dataCallback)
    }


    companion object {

        private val BASE_URL = "https://api.githunt.com/graphql"
        //private val SUBSCRIPTION_BASE_URL = "wss://api.githunt.com/subscriptions"

    }
}
