package com.devdhruv.roomdb.addData

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdhruv.roomdb.data.Name
import com.devdhruv.roomdb.data.NameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddDataViewModel @ViewModelInject constructor(
    private val nameRepository: NameRepository
): ViewModel() {

    val genders = arrayListOf("Male", "Female")
    val headingsPos = MutableLiveData<Int>()

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()

    private var _navigateToShowData =  MutableLiveData<Boolean?>()
    val navigateToShowData: LiveData<Boolean?> get() = _navigateToShowData

    fun onNavigateClick(){
        _navigateToShowData.value = true
    }

    fun onAddName(){

        viewModelScope.launch(Dispatchers.IO) {

            var name = Name()
            name.firstName = firstName.value.toString()
            name.lastName = lastName.value.toString()
            if (headingsPos.value == 0) name.gender = "Male"
            else name.gender = "Female"

            nameRepository.insertData(name)

        }

    }
}