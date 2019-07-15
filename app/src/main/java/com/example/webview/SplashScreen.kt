package com.example.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed



class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
       // getSupportActionBar()!!.hide() // hide the title bar
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {
            val splash = Intent(this, MainActivity::class.java)
            startActivity(splash)
            finish()
        }, SPLASH_TIME_OUT.toLong())

    }
}
