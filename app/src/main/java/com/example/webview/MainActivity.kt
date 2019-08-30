package com.example.webview

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.settings.javaScriptEnabled = true
        val url = "http://www.aeoowa.org"

        web_view.webViewClient = object: WebViewClient(){

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

                if (url!!.startsWith("http://www.aeoowa.org"))
                {

                    web_view.loadUrl(url)
                }
                else
                {
                    val intent = Intent(ACTION_VIEW, Uri.parse(url))
                    view?.context?.startActivity(intent)
                }
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE
                progress_bar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                view?.visibility = View.VISIBLE
                progress_bar.visibility = View.INVISIBLE
            }
        }

        web_view.loadUrl(url)
    }
}
