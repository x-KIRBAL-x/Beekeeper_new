package com.example.android.myapplication.renamebeegroup

import android.graphics.Typeface
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.myapplication.database.BeeGroup

@BindingAdapter("SetNewGroupName")
fun TextView.setGrouoName(item: BeeGroup?){
    item?.let {
        if (item.groupName != ""){
            text = item.groupName
            setTypeface(null, Typeface.BOLD)
        }
    }
}

@BindingAdapter("SetNewLocation")
fun TextView.setLocation(item: BeeGroup?){
    item?.let {
        if (item.groupLocation != ""){
            text = item.groupLocation
            setTypeface(null, Typeface.BOLD)
        }
    }
}