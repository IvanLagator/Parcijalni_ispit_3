package com.example.ispitmodul3.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class GroceryRepository(application: Application) {

    var groceryDao: GroceryDao

    var allGroceries: LiveData<List<Grocery>>

    init {
        val database = GroceriesDatabase.getInstance(application)
        groceryDao = database.userDao()
        allGroceries = groceryDao.getAllGroceries()
    }

    fun insert(grocery: Grocery) {
        InsertGroceryAsyncTask(groceryDao).execute(grocery)
    }

    fun delete(grocery: Grocery) {
        DeleteGroceryAsyncTask(groceryDao).execute(grocery)
    }


    companion object {

        class InsertGroceryAsyncTask(val groceryDao: GroceryDao) :
            AsyncTask<Grocery, Unit, Unit>() {
            override fun doInBackground(vararg groceries: Grocery?) {
                groceries[0]?.let { groceryDao.insert(it) }
            }
        }
    }

    class DeleteGroceryAsyncTask(val groceryDao: GroceryDao) : AsyncTask<Grocery, Unit, Unit>() {
        override fun doInBackground(vararg groceries: Grocery?) {
            groceries[0]?.let { groceryDao.delete(it) }
        }
    }
}
