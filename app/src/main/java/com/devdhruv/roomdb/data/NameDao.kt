package com.devdhruv.roomdb.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(name: Name)

    @Query("SELECT*FROM name_table ORDER BY id ASC")
    fun readData(): Flow<List<Name>>

    @Query("SELECT*FROM name_table WHERE gender = :filter")
    fun searchDatabase(filter: String): Flow<List<Name>>

}