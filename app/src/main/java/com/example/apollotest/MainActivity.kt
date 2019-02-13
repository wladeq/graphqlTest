package com.example.apollotest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log.wtf
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

//    private var apolloClient: ApolloClient? = null
//    internal var githuntFeedCall: ApolloCall<TestQuery.Data>? = null
//    internal var uiHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Ten sposób jest bez Apollo, i to działa :
        doAsync {
            wtf("===Response===\n", RequestHandler().makeRequest())
        }

        //
        // A ten zakomentowany sposób jest z Apollo, nie działa w przypadku naszego serweru, ale działa z serwerem Staszka

//        val okHttpClient = OkHttpClient.Builder()
//                .build()
//        val FEED_SIZE = 20
//        val dataCallback = ApolloCallback(object : ApolloCall.Callback<TestQuery.Data>() {
//            override fun onResponse(response: Response<TestQuery.Data>) {
//                print("Norm - ")
//            }
//
//            override fun onFailure(e: ApolloException) {
//                print("Nie norm - ")
//            }
//        }, uiHandler)
//
//
//        apolloClient = ApolloClient.builder()
//                .serverUrl(BASE_URL)
//                .okHttpClient(okHttpClient)
//                //.subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory(SUBSCRIPTION_BASE_URL, okHttpClient))
//                .build()
//
//        var apolloClientCopy = apolloClient
//
//        val feedQuery: TestQuery = TestQuery.builder()
//                .limit(FEED_SIZE)
//                .type(FeedType.HOT)
//                .build()
//
//        githuntFeedCall = apolloClientCopy?.query(feedQuery)
//                ?.responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
//        githuntFeedCall?.enqueue(dataCallback)

    }

    companion object {

        private val BASE_URL = "https://eu1.prisma.sh/jaroslavi-b7c2e1/apollo/dev"
        //private val SUBSCRIPTION_BASE_URL = "wss://api.githunt.com/subscriptions"

    }

}
