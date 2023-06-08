package com.example.android.myapplication.renamebeehive

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.myapplication.database.BeeDatabaseDao
import com.example.android.myapplication.database.Beehive
import kotlinx.coroutines.launch

class RenameBeehiveViewModel(
    dataSource: BeeDatabaseDao,
    private val beeGroupKey: Long,
    private val beehiveKey: Long) : ViewModel() {

     val database = dataSource

    private val beehive: LiveData<Beehive>

    init {
        beehive = database.getBeehiveWithId(beehiveKey)
    }

    fun getBeehive() = beehive

    private val _navigateToBeehiveDetailFragment = MutableLiveData<Boolean?>()

    val navigateToBeehiveDetailFragment: LiveData<Boolean?>
        get() = _navigateToBeehiveDetailFragment

    fun clickOnDoneButton(){
        _navigateToBeehiveDetailFragment.value=true
    }
    fun doneNavigateToBeehiveDetailFragment(){
        _navigateToBeehiveDetailFragment.value=null
    }

   fun setNewName(newBeehiveName: String){
        viewModelScope.launch {
            val updateBeehive = beehive.value ?: return@launch
            updateBeehive.beehiveName = newBeehiveName
            database.updateHive(updateBeehive)
        }
    }

}