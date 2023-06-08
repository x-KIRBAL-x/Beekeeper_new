package com.example.android.myapplication.renamebeegroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.myapplication.database.BeeDatabaseDao
import com.example.android.myapplication.database.BeeGroup
import kotlinx.coroutines.launch

class RenameBeeGroupViewModel(dataSource: BeeDatabaseDao,
                              private val groupKey: Long) : ViewModel() {

    val database = dataSource

    private val group: LiveData<BeeGroup>

    fun getGroup() = group

    init {
        group = database.getGroupWithId(groupKey)
    }

    private val _clickDoneButton = MutableLiveData<Int?>()

    val clickDoneButton: LiveData<Int?>
        get() = _clickDoneButton

    fun doneNavigatingToBeehivesFragment(){
        _clickDoneButton.value=null
    }

    fun clickDoneButton(){
        _clickDoneButton.value=1
    }

    fun setvalue(newName: String, newLocation: String){
        viewModelScope.launch {
            val newgroup = group.value ?: return@launch
            newgroup.groupName = newName
            newgroup.groupLocation = newLocation
            database.updateGroup(newgroup)
        }
    }
}