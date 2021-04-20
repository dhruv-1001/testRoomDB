package com.devdhruv.roomdb.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NameRepository @Inject constructor(
    private val nameDao: NameDao
) {

    fun readData(): Flow<List<Name>>{
        return nameDao.readData()
    }

    suspend fun insertData(name: Name){
        nameDao.insertData(name)
    }

    fun searchDatabase(filter: String): Flow<List<Name>>{
        return nameDao.searchDatabase(filter)
    }

}