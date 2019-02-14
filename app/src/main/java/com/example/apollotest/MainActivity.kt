package com.example.apollotest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getIds() {


    }

    companion object {

        private val BASE_URL = "https://eu1.prisma.sh/jaroslavi-b7c2e1/apollo/dev"

    }
}
