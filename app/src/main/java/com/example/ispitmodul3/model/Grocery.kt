package com.example.ispitmodul3.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ispitmodul3.other.GROCERIES_TABLE_NAME

@Entity(tableName = GROCERIES_TABLE_NAME)
data class Grocery (val name: String, val calories: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}