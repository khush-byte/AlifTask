package com.khush.aliftask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.khush.aliftask.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getDataFlow()
        viewModel.response.observe(this, Observer {
            Log.d(TAG, it.toString())
        })
    }

    companion object {
        const val TAG = "DebugTag"
    }
}