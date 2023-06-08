package com.example.android.myapplication.addnewgroup

import android.graphics.Typeface
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.myapplication.database.BeeGroup

@BindingAdapter("SetGroupName")
fun TextView.setGrouoName(item: BeeGroup?){
    item?.let {
        if (item.groupName != ""){
            text = item.groupName
            setTypeface(null,Typeface.BOLD)
        }
    }
}

@BindingAdapter("SetLocation")
fun TextView.setLocation(item: BeeGroup?){
    item?.let {
        if (item.groupLocation != ""){
            text = item.groupLocation
            setTypeface(null,Typeface.BOLD)
        }
    }
}