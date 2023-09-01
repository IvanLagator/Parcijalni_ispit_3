package com.example.ispitmodul3.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ispitmodul3.other.GROCERIES_TABLE_NAME


@Dao
interface GroceryDao {

    @Insert
    fun insert(grocery: Grocery)

    @Delete
    fun delete(grocery: Grocery)

    @Query("SELECT * FROM $GROCERIES_TABLE_NAME")
    fun getAllGroceries(): LiveData<List<Grocery>>
}