package com.medicus.app.presentation.biomarkers

import android.view.View
import android.widget.Toast
import com.medicus.app.R
import com.medicus.app.core.UiStateStatus
import com.medicus.app.data.model.Biomarker
import com.medicus.app.databinding.BiomarkerListItemBinding
import com.medicus.app.databinding.FragmentBiomarkersBinding
import com.medicus.app.presentation.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


class BiomarkersFragment : BaseFragment<FragmentBiomarkersBinding, BiomarkersViewModel>() {

    private val viewModel: BiomarkersViewModel by viewModel()

    private val biomarkersAdapter by lazy { BiomarkersRecyclerAdapter() }

    private val itemDecorator by lazy {
        BiomarkersMarginDecoration(
            requireContext(),
            R.dimen.dp_16
        )
    }

    override fun layoutId(): Int = R.layout.fragment_biomarkers

    override fun initFragment() {
        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        with(binding) {
            biomarkersRecyclerView.apply {
                adapter = biomarkersAdapter
                postponeEnterTransition()
                viewTreeObserver.addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
                addItemDecoration(itemDecorator)
            }
            swipeRefresh.setOnRefreshListener { viewModel.refreshBiomarkers() }
            biomarkersAdapter.listener = { biomarker, binding ->
                onBiomarkerClicked(biomarker, binding)
            }
        }
    }

    private fun initObservers() = with(viewModel) {
        launchOnLifecycleScope {
            biomarkersStateFlow.collectLatest {
                when(it.status){
                    UiStateStatus.LOADING -> bindLoadingState(it.data)
                    UiStateStatus.SUCCESS -> bindSuccessState(it.data!!)
                    UiStateStatus.NO_RESULTS -> bindNoResultsState()
                    UiStateStatus.FAILURE -> bindFailureState(it.message!!)
                }
            }
        }
    }

    private fun bindLoadingState(biomarkers: List<Biomarker>?) {
        biomarkers?.let { binding.swipeRefresh.isRefreshing = true }

        with(binding.networkStateLayout){
            root.visibility = View.VISIBLE
            if(biomarkers==null) progressBar.visibility = View.VISIBLE
            errorMsg.visibility = View.GONE
            retryButton.visibility = View.GONE
        }
    }

    private fun bindSuccessState(biomarkers: List<Biomarker>) {
        binding.swipeRefresh.isRefreshing = false
        with(binding.networkStateLayout) {
            root.visibility = View.GONE
            progressBar.visibility = View.GONE
        }
        biomarkersAdapter.setList(biomarkers)
    }

    private fun bindNoResultsState() {
        binding.swipeRefresh.isRefreshing = false
        biomarkersAdapter.setList(listOf())
        with(binding.networkStateLayout) {
            root.visibility = View.VISIBLE
            errorMsg.visibility = View.VISIBLE
            retryButton.visibility = View.GONE
            progressBar.visibility = View.GONE
            errorMsg.text = getString(R.string.no_results_message)
        }
    }

    private fun bindFailureState(message: String) {
        binding.swipeRefresh.isRefreshing = false
        biomarkersAdapter.setList(listOf())
        with(binding.networkStateLayout) {
            root.visibility = View.VISIBLE
            errorMsg.visibility = View.VISIBLE
            retryButton.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            errorMsg.text = message
            retryButton.setOnClickListener {
                viewModel.refreshBiomarkers()
            }
        }
    }

    private fun onBiomarkerClicked(biomarker: Biomarker, binding: BiomarkerListItemBinding) {
        // TODO
//        val extras = FragmentNavigatorExtras(
//            binding.biomarkerAvatar to "biomarkerAvatar_${biomarker.id}",
//        )
//        findNavController().navigate(
//            BiomarkersFragmentDirections.actionBiomarkersToBiomarkerDetail(biomarker),
//            extras
//        )
    }
}