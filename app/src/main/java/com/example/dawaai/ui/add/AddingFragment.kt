package com.example.dawaai.ui.add

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dawaai.R
import com.example.dawaai.data.models.ItemFoFirebase
import com.example.dawaai.databinding.FragmentAddingBinding

class AddingFragment : Fragment() {

    private lateinit var viewModel: AddingViewModel
    private lateinit var binding: FragmentAddingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_adding, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = AddingViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[AddingViewModel::class.java]
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        viewModel.onButtonClicked.observe(viewLifecycleOwner, Observer {
            if (it) {
                getDataFromUser()
            }
        })

    }

    private fun getDataFromUser() {
        val name = binding.name.text.toString()
        val information = binding.information.text.toString()
        if (name.isEmpty()) {
            return
        }

        if (information.isEmpty()) {
            return
        }
        viewModel.addDataToFirebase(ItemFoFirebase(name = name , information =  information))
        binding.name.text?.clear()
        binding.information.text?.clear()

    }

}