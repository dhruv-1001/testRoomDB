package com.devdhruv.roomdb.addData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.devdhruv.roomdb.R
import com.devdhruv.roomdb.databinding.FragmentAddDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDataFragment : Fragment() {

    private val addDataViewModel: AddDataViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_data, container, false
        )
        binding.addDataViewModel = addDataViewModel

        addDataViewModel.navigateToShowData.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_addDataFragment_to_viewNameFragment)
        })

        return binding.root
    }

}