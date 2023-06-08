package com.example.android.myapplication.swarmqueencellsdescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.myapplication.R
import com.example.android.myapplication.databinding.FragmentSwarmQueenCellsInfoBinding

class SwarmQueenCellsDescription: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSwarmQueenCellsInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_swarm_queen_cells_info,container,false)
        return binding.root
    }
}