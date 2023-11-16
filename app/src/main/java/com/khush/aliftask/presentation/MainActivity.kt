package com.khush.aliftask.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.khush.aliftask.data.models.ItemData
import com.khush.aliftask.databinding.ActivityMainBinding
import com.khush.aliftask.presentation.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = ItemAdapter(this)
        adapter.onItemClickListener = object: ItemAdapter.OnItemClickListener{
            override fun onItemClick(itemInfo: ItemData) {
                launchDetailActivity(itemInfo.url)
            }
        }
        binding.rvItemList.layoutManager = LinearLayoutManager(this)
        binding.rvItemList.adapter = adapter
        binding.rvItemList.itemAnimator = null

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        viewModel.getDataFlow()
        viewModel.itemList.observe(this){
            if (it != null) {
                //Log.d(TAG, it.toString())
                adapter.submitList(it)
            }
        }
    }

    private fun launchDetailActivity(url: String) {
        val intent = Intent(this@MainActivity, WebViewActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }

    companion object {
        const val TAG = "DebugTag"
    }
}