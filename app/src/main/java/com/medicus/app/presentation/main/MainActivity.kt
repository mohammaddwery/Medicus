package com.medicus.app.presentation.main

import com.medicus.app.R
import com.medicus.app.databinding.ActivityMainBinding
import com.medicus.app.presentation.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun layoutId(): Int = R.layout.activity_main
    override fun getVM(): MainViewModel = mainViewModel
    override fun bindVM(binding: ActivityMainBinding, vm: MainViewModel) = Unit
}