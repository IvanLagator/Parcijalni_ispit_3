package com.example.ispitmodul3.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryRepository(application: Application) {

    var groceryDao: GroceryDao

    var allGroceries: LiveData<List<Grocery>>

    init {
        val database = GroceriesDatabase.getInstance(application)
        groceryDao = database.userDao()
        allGroceries = groceryDao.getAllGroceries()
    }
    fun insert(grocery: Grocery?) {
        GlobalScope.launch(Dispatchers.IO) {
            grocery?.let {
                groceryDao.insert(it)
            }
        }
    }
    fun delete(grocery: Grocery?) {
        GlobalScope.launch(Dispatchers.IO) {
            grocery?.let {
                groceryDao.delete(it)
            }
        }
    }
}
