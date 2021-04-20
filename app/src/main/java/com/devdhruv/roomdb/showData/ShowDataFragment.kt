package com.devdhruv.roomdb.showData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devdhruv.roomdb.R
import com.devdhruv.roomdb.databinding.FragmentViewNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowDataFragment : Fragment() {

    private lateinit var binding: FragmentViewNameBinding

    private val showDataViewModel: ShowDataViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_view_name, container, false
        )
        binding.showDataViewModel = showDataViewModel

        showDataViewModel.navigateToAddData.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_viewNameFragment_to_addDataFragment)
        })

        return binding.root

    }

}