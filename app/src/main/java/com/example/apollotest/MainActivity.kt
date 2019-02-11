package com.example.apollotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloCallback
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.cache.normalized.CacheKey
import com.apollographql.apollo.cache.normalized.CacheKeyResolver
import com.apollographql.apollo.cache.normalized.lru.EvictionPolicy
import com.apollographql.apollo.cache.normalized.lru.LruNormalizedCacheFactory
import com.apollographql.apollo.cache.normalized.sql.ApolloSqlHelper
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
import com.example.apollotest.FeedQuery
import com.example.apollotest.type.FeedType
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
//    fun ApolloClient(): ApolloClient? {
//        return apolloClient
//    }
    private var apolloClient: ApolloClient? = null
    internal var githuntFeedCall: ApolloCall<FeedQuery.Data>? = null
    internal var uiHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val okHttpClient = OkHttpClient.Builder()
                .build()
        val FEED_SIZE = 20

        val dataCallback = ApolloCallback(object : ApolloCall.Callback<FeedQuery.Data>() {
            override fun onResponse(response: Response<FeedQuery.Data>) {
                Log.wtf("VSENORM - ", response.toString())
            }

            override fun onFailure(e: ApolloException) {
                Log.wtf("SHOTO NIE POSZLO - ", e)
            }
        }, uiHandler)


        apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                //.subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory(SUBSCRIPTION_BASE_URL, okHttpClient))
                .build()
        var apolloClientCopy = apolloClient
        val feedQuery: FeedQuery = FeedQuery.builder()
                .build()
        githuntFeedCall = apolloClientCopy?.query(feedQuery)
                ?.responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
        githuntFeedCall?.enqueue(dataCallback)
    }


    companion object {

        private val BASE_URL = "http://172.20.10.25:4000"
        //private val SUBSCRIPTION_BASE_URL = "wss://api.githunt.com/subscriptions"

    }
}
