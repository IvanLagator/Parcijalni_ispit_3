package com.example.ispitmodul3.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ispitmodul3.other.GROCERY_DATABASE_NAME

@Database(entities = [Grocery::class], version = 1, exportSchema = true)
abstract class GroceriesDatabase: RoomDatabase() {

    abstract fun userDao(): GroceryDao

    companion object{
        var instance: GroceriesDatabase? = null

        @Synchronized
        fun getInstance(context: Context): GroceriesDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context.applicationContext, GroceriesDatabase::class.java, GROCERY_DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as GroceriesDatabase
        }
    }
}