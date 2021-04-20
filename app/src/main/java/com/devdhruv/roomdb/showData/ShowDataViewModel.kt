package com.devdhruv.roomdb.showData

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.roomdb.data.NameRepository

class ShowDataViewModel @ViewModelInject constructor(
    private val nameRepository: NameRepository
): ViewModel() {

    private var _navigateToAddData =  MutableLiveData<Boolean?>()
    val navigateToAddData: LiveData<Boolean?> get() = _navigateToAddData


    fun onNavigateClick(){
        _navigateToAddData.value = true
    }

}