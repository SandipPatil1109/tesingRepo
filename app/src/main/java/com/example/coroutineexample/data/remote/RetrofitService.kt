package com.example.coroutineexample.data.remote

import com.example.coroutineexample.domain.model.PostDetails
import com.example.coroutineexample.domain.model.PostDetailsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("/posts")
    fun getPosts():Call<List<PostDetails>>

    companion object{

        var retrofitService:RetrofitService? = null

        fun getInstance():RetrofitService{
            if(retrofitService==null){
                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                   retrofitService = retrofitBuilder.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}