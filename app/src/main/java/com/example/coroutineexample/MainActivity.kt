package com.example.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coroutineexample.data.remote.RetrofitService
import com.example.coroutineexample.databinding.ActivityMainBinding
import com.example.coroutineexample.domain.repository.MainRepository
import com.example.coroutineexample.ui.adapter.MainAdapter
import com.example.coroutineexample.ui.viewmodel.MainViewModel
import com.example.coroutineexample.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerView.adapter = adapter
        viewModel.postList.observe(this, Observer {

            adapter.setPostLists(it.get(0))
        })
        viewModel.errorMessage.observe(this, Observer {

          Toast.makeText(this,""+it,Toast.LENGTH_LONG).show()
        })

        viewModel.getAllPosts()
    }
}