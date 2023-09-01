package com.example.ispitmodul3.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ispitmodul3.model.Grocery
import com.example.ispitmodul3.model.GroceryRepository


class GroceryViewModel(application: Application) : AndroidViewModel(application){

    var groceryRepository: GroceryRepository
    var allGroceries: LiveData<List<Grocery>>

    init {
        groceryRepository = GroceryRepository(application)
        allGroceries = groceryRepository.allGroceries
    }
    fun insert(grocery: Grocery){
        groceryRepository.insert(grocery)
    }
    fun delete(grocery: Grocery){
        groceryRepository.delete(grocery)
    }
}