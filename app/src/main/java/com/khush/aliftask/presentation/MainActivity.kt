package com.khush.aliftask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.khush.aliftask.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        viewModel.getDataFlow()
        viewModel.itemList.observe(this){
            Log.d(TAG, it.toString())
        }
    }

    companion object {
        const val TAG = "DebugTag"
    }
}