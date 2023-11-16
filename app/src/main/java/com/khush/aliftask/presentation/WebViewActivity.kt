package com.khush.aliftask.presentation

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.khush.aliftask.R
import com.khush.aliftask.presentation.MainActivity.Companion.TAG

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var pageLoading: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra("url")
        webView = findViewById(R.id.item_web_view)
        pageLoading = findViewById(R.id.page_loading)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pageLoading.visibility = View.GONE
            }
        }

        if (url != null) {
            Log.d(TAG, url)
            webView.loadUrl(url)
        }
    }
}