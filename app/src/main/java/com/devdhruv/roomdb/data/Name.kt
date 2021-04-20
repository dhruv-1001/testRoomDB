package com.devdhruv.roomdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table")
data class Name (
    var firstName: String = "",
    var lastName: String = "",
    var gender: String = ""
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}