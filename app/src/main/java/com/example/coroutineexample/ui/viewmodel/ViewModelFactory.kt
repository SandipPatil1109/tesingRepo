package com.example.coroutineexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutineexample.domain.repository.MainRepository

class ViewModelFactory constructor(val repository: MainRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MainViewModel::class.java)){
               MainViewModel(this.repository) as T
        }else{
         throw IllegalArgumentException("viewModel not found")
        }
    }
}