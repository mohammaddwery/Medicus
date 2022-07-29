package com.medicus.app.di

import com.medicus.app.presentation.biomarkers.BiomarkersViewModel
import com.medicus.app.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MainViewModel() }
    viewModel { BiomarkersViewModel( biomarkerRepository = get(), userRepository = get()) }
}
