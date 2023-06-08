package com.example.android.myapplication.renamebeehive

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.myapplication.database.Beehive

@BindingAdapter("SetNewBeehiveName")
fun TextView.setNewBeehiveName(item: Beehive?){
    item?.let {
        text = item.beehiveName
    }
}