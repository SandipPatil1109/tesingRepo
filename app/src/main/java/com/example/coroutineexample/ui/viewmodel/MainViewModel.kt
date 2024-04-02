package com.example.coroutineexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutineexample.domain.model.PostDetails
import com.example.coroutineexample.domain.model.PostDetailsItem
import com.example.coroutineexample.domain.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor( private val repository: MainRepository):ViewModel() {


    val postList = MutableLiveData<List<PostDetails>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllPosts(){

        val response  = repository.getPosts()
        response.enqueue(object: Callback<List<PostDetails>>{
            override fun onResponse(
                call: Call<List<PostDetails>>,
                response: Response<List<PostDetails>>
            ) {
                 postList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PostDetails>>, t: Throwable) {
                  errorMessage.postValue(t.message)
            }

        })
    }
}