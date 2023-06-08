package com.example.android.myapplication.beehivereview

import android.graphics.Typeface
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.myapplication.R
import com.example.android.myapplication.convertNumericQualityToString
import com.example.android.myapplication.convertNumericQuantityToString
import com.example.android.myapplication.database.Beehive

@BindingAdapter("QueenbeeYearEdit")
fun EditText.setQueenbeeYear(item: Beehive?){
    item?.let {
        hint = item.queenBeeYear.toString()
        setTypeface(null,Typeface.BOLD)
    }
}

@BindingAdapter("QueenbeeCondition")
fun TextView.setQueenbeeCondition(item: Beehive?){
    item?.let {
        text = resources.getString(R.string.quennbee_condition_text) + convertNumericQualityToString(item.queenBeeState,context.resources)
        setTypeface(null,Typeface.BOLD)
    }
}

@BindingAdapter("BeehivePopulation")
fun TextView.setBeehivePopulation(item: Beehive?){
    item?.let {
        text = resources.getString(R.string.beehive_population_text) + convertNumericQualityToString(item.BeehivePopulation,context.resources)
        setTypeface(null,Typeface.BOLD)
    }
}

@BindingAdapter("BroodframeQuantity")
fun TextView.setBroodframeQuantity(item: Beehive?){
    item?.let {
        text = resources.getString(R.string.broodframe_quantity_text) + convertNumericQuantityToString(item.broodFrame,context.resources)
        setTypeface(null,Typeface.BOLD)
    }
}

@BindingAdapter("HoneyframeQuantity")
fun TextView.setHoneyframeQuantity(item: Beehive?){
    item?.let {
        text = resources.getString(R.string.honeyframe_quantity_text) + convertNumericQuantityToString(item.honeyFrame,context.resources)
        setTypeface(null,Typeface.BOLD)
    }
}

@BindingAdapter("BroodframeNumber")
fun TextView.setBroodframeNumber(item: Beehive?){
    item?.let {
        if(item.broodFrameNumber != -1){
            hint = item.broodFrameNumber.toString()
            setTypeface(null,Typeface.BOLD)
        }
        else{
            hint = "Edit"
            setTypeface(null,Typeface.BOLD)
        }
    }
}

@BindingAdapter("HoneyframeNumber")
fun TextView.setHoneyframeNumber(item: Beehive?){
    item?.let {
        if(item.honeyFrameNumber != -1){
            hint = item.honeyFrameNumber.toString()
            setTypeface(null,Typeface.BOLD)
        }
        else{
            hint = "Edit"
            setTypeface(null,Typeface.BOLD)
        }
    }
}

@BindingAdapter("Nosema")
fun Switch.setNosemaValue(item: Beehive?){
    item?.let {
        isChecked = item.nosema==1
    }
}

@BindingAdapter("AscosphaeraApis")
fun Switch.setAscosphaeraApis(item: Beehive?){
    item?.let {
        isChecked = item.AscosphaeraApis==10
    }
}

@BindingAdapter("SwarmQueenCells")
fun Switch.setSwarmQueenCellsValue(item: Beehive?){
    item?.let {
        isChecked = item.swarmingQueenCells==1
    }
}


