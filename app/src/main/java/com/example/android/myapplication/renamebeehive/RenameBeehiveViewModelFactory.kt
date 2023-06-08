package com.example.android.myapplication.renamebeehive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.database.BeeDatabaseDao

class RenameBeehiveViewModelFactory(
    private val dataSource: BeeDatabaseDao,
    private val groupKey: Long,
    private val beehiveKey: Long): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RenameBeehiveViewModel::class.java)){
            return RenameBeehiveViewModel(dataSource,groupKey,beehiveKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}