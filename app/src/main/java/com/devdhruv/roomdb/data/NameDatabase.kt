package com.devdhruv.roomdb.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Name::class],
    version = 1,
    exportSchema = false
)
abstract class NameDatabase: RoomDatabase() {

    abstract fun nameDao(): NameDao

}