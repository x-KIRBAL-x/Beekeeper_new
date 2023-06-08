package com.example.android.myapplication.swarmingbeesdescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.myapplication.R
import com.example.android.myapplication.databinding.FragmentSwarmingBeesInfoBinding

class SwarmingBeesDescriptionFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSwarmingBeesInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_swarming_bees_info,container,false)
     return binding.root
    }
}