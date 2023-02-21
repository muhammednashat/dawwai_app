package com.example.dawaai.ui.detailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.dawaai.R
import com.example.dawaai.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        val args =    DetailsFragmentArgs.fromBundle(requireArguments())
        binding.tvName.text = args.item.name
        binding.tvInformation.text = args.item.information

        return binding.root
    }


}