package com.example.android.myapplication.beestatistics

import androidx.lifecycle.ViewModel
import com.example.android.myapplication.database.BeeDatabaseDao
import java.text.SimpleDateFormat
import java.util.*

class BeeStatisticsViewModel(
    private val groupKey: Long,
    dataSource: BeeDatabaseDao): ViewModel() {


    val database = dataSource

    fun getCountPopulation(index: Int): Int{
        val count: Int? = database.getCountPopulationBeehives(groupKey, index)
        return if(count==null){
            0
        } else{
            count
        }
    }

    fun getCountQueenbeeState(index: Int): Int{
        val count: Int? = database.getCountQueenbeeState(groupKey, index)
        return if(count==null){
            0
        } else{
            count
        }
    }

    fun getQueenBeeYear(index: Int): Int{
        val count: Int? = database.getCountQueenBeeAge(groupKey,
            SimpleDateFormat("yyyy").format(Date()).toString().toInt()-index)
        return if(count==null){
            0
        } else{
            count
        }
    }

    fun getAllBadQueenbee(): Int{
        val count: Int? = database.getAllBadQueenBee(groupKey, SimpleDateFormat("yyyy").format(Date()).toString().toInt()-2)
        return if(count==null){
            0
        } else{
            count
        }
    }

    fun getAllHive(): Int{
        val count: Int? = database.getAllHive(groupKey)
        return if(count==null){
            0
        } else{
            count
        }
    }

    fun getAllSickHive(): Int{
        val count: Int? = database.getCountSicksBees(groupKey)
        return if(count==null){
            0
        } else{
            count
        }
    }

    fun getAllSwarmingBeeHives(): Int{
        val count: Int? = database.getCountSwarmingBees(groupKey, SimpleDateFormat("yyyy").format(Date()).toString().toLong() - 2)
        return if(count==null){
            0
        } else{
            count
        }
    }

}