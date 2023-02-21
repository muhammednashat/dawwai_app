package com.example.dawaai.di

import com.example.dawaai.ui.mainScreenFragment.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {

    viewModel { MainScreenViewModel(get()) }


}