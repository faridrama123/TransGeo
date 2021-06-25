package com.faridrama123.transgeo.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.faridrama123.transgeo.R
import kotlinx.coroutines.*

class SplashScreen : AppCompatActivity() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        exampleMethod()

    }
    fun exampleMethod() {7
        // Starts a new coroutine within the scope
        scope.launch {
            // New coroutine that can call suspend functions
            delay(2000L)
            val intent = Intent(this@SplashScreen, HomeActivity::class.java)
            startActivity(intent)

        }
    }

}