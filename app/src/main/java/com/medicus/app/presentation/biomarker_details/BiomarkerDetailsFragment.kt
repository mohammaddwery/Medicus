package com.medicus.app.presentation.biomarker_details

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.medicus.app.R
import com.medicus.app.presentation.base.BaseFragment
import android.view.ContextThemeWrapper
import com.medicus.app.databinding.FragmentBiomarkerDetailsBinding


class BiomarkerDetailsFragment : BaseFragment<FragmentBiomarkerDetailsBinding, BiomarkerDetailsViewModel>() {

    override fun layoutId(): Int = R.layout.fragment_biomarker_details

    private val args: BiomarkerDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
    }

    override fun initFragment() {
        bindInitialState()
        onClickListeners()
    }

    private fun bindInitialState() {
        ViewCompat.setTransitionName(binding.biomarkerLayout.biomarkerLayout, "biomarkerLayout_${args.biomarker.symbol}_${args.biomarker.id}")
        binding.biomarker = args.biomarker
    }

    private fun onClickListeners() {
        binding.infoImageButton.setOnClickListener {
            activity?.let {
                val builder = AlertDialog.Builder(
                    ContextThemeWrapper(it, R.style.CustomAlertDialog)
                )
                builder.setMessage(args.biomarker.info)
                val alertDialog :AlertDialog = builder.create()
                alertDialog.window?.attributes?.windowAnimations = R.style.CustomAlertDialog
                alertDialog.show()
            }
        }
    }
}