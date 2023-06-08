package com.example.android.myapplication.renamebeegroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.myapplication.R
import com.example.android.myapplication.addnewgroup.AddNewGroupFragmentDirections
import com.example.android.myapplication.database.BeeDatabase
import com.example.android.myapplication.databinding.FragmentRenameBeegroupBinding

class RenameBeeGroupFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRenameBeegroupBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_rename_beegroup, container, false)

        val application = requireNotNull(this.activity).application

        val arguments = RenameBeeGroupFragmentArgs.fromBundle(requireArguments())

        val dataSource = BeeDatabase.getInstance(application).beeDatabaseDao
        val viewModelFactory = RenameBeeGroupViewModelFactory(dataSource,arguments.groupKey)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.setLifecycleOwner(this)

        val renameBeeGoupViewModel = ViewModelProvider(this,viewModelFactory).get(RenameBeeGroupViewModel::class.java)

        binding.renameBeeGroupViewModel = renameBeeGoupViewModel

        renameBeeGoupViewModel.clickDoneButton.observe(this, Observer {
            if (it!=null) {
                if( binding.newGroupName.text.toString() != "" && binding.newGroupLocation.text.toString() != ""){
                    val groupNameLenght: Int = binding.newGroupName.text.toString().length
                    val groupLocationLenght: Int = binding.newGroupLocation.text.toString().length
                    if (groupNameLenght<12) {
                        if (groupLocationLenght<21) {
                            if (it == 1) {
                                renameBeeGoupViewModel.setvalue(
                                    binding.newGroupName.text.toString(),
                                    binding.newGroupLocation.text.toString()
                                )
                                this.findNavController().navigate(RenameBeeGroupFragmentDirections.actionRenameBeegroupToBeehivesFragment(arguments.groupKey))
                                renameBeeGoupViewModel.doneNavigatingToBeehivesFragment()
                            }
                        }
                        else{
                            Toast.makeText(application,resources.getString(R.string.group_location_lenght_warrning),
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        Toast.makeText(application,resources.getString(R.string.group_name_lenght_warrning),
                            Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(application,resources.getString(R.string.empty_field_warrning),
                        Toast.LENGTH_SHORT).show()
                }

            }
        })

    return binding.root
    }
}