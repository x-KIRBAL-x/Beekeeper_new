package com.example.android.myapplication.renamebeehive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.myapplication.R
import com.example.android.myapplication.database.BeeDatabase
import com.example.android.myapplication.databinding.FragmentRenameBeehiveBinding

class RenameBeehiveFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRenameBeehiveBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_rename_beehive, container, false)

        val application = requireNotNull(this.activity).application

        val arguments = RenameBeehiveFragmentArgs.fromBundle(requireArguments())

        val dataSource = BeeDatabase.getInstance(application).beeDatabaseDao

        val viewModelFactory = RenameBeehiveViewModelFactory(dataSource,arguments.beeGroupKey,arguments.beehivekey)

        val renameBeehiveViewModel = ViewModelProvider(this, viewModelFactory).get(RenameBeehiveViewModel::class.java)

        binding.renameBeehiveViewModel = renameBeehiveViewModel

        binding.setLifecycleOwner(this)

        renameBeehiveViewModel.navigateToBeehiveDetailFragment.observe(this, Observer {
            if (it==true){
                var newName: String = binding.renameBeehive.text.toString()
                var textLenght: Int = newName.length
                if(newName!="") {
                    if (textLenght<8) {
                        renameBeehiveViewModel.setNewName(newName)
                        this.findNavController().navigate(
                            RenameBeehiveFragmentDirections.actionRenameBeehiveFragmentToBeehiveDetailFragment(
                                arguments.beehivekey,
                                arguments.beeGroupKey
                            )
                        )
                        renameBeehiveViewModel.doneNavigateToBeehiveDetailFragment()
                    }
                    else{
                        Toast.makeText(application, resources.getString(R.string.hive_name_lenght_warrning),Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(application, resources.getString(R.string.empty_field_warrning),Toast.LENGTH_SHORT).show()
                }
            }
        })
        binding.renameBeehive.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 7){
                binding.newBeehiveNameLayout.error = "No More!"
            }
            else if (text.length <=7){
                binding.newBeehiveNameLayout.error = null
            }
        }
        return binding.root
    }
}