package com.example.ispitmodul3.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ispitmodul3.other.GROCERIES_TABLE_NAME

@Dao
interface GroceryDao {

    @Insert
    fun insert(grocery: Grocery)

    @Update
    fun update(grocery: Grocery)

    @Delete
    fun delete(grocery: Grocery)

    @Query("DELETE FROM $GROCERIES_TABLE_NAME")
    fun deleteAllReminders()

    @Query("SELECT * FROM $GROCERIES_TABLE_NAME")
    fun getAllReminders(): LiveData<List<Grocery>>
}