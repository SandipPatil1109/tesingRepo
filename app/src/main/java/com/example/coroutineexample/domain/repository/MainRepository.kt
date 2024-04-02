package com.example.coroutineexample.domain.repository

import com.example.coroutineexample.data.remote.RetrofitService

class MainRepository constructor( private val retrofitService: RetrofitService) {

    fun getPosts() =retrofitService.getPosts()
}