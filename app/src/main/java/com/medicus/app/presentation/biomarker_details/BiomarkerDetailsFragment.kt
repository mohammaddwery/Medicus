package com.medicus.app.presentation.biomarker_details

import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.medicus.app.R
import com.medicus.app.databinding.FragmentBiomarkerDetailsBinding
import com.medicus.app.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BiomarkerDetailsFragment : BaseFragment<FragmentBiomarkerDetailsBinding, BiomarkerDetailsViewModel>() {

    private val viewModel: BiomarkerDetailsViewModel by viewModel()

    override fun layoutId(): Int = R.layout.fragment_biomarker_details

    private val args: BiomarkerDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
    }

    override fun initFragment() {
        bindInitialState()
    }

    private fun bindInitialState() {
        ViewCompat.setTransitionName(binding.biomarkerLayout.biomarkerLayout, "biomarkerLayout_${args.biomarker.symbol}_${args.biomarker.id}")
        binding.biomarker = args.biomarker
    }
}