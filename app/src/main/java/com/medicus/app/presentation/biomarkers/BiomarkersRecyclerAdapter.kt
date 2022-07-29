package com.medicus.app.presentation.biomarkers

import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import com.medicus.app.R
import com.medicus.app.data.model.Biomarker
import com.medicus.app.databinding.BiomarkerListItemBinding
import com.medicus.app.presentation.base.BaseRecyclerAdapter

class BiomarkersRecyclerAdapter : BaseRecyclerAdapter<Biomarker, BiomarkerListItemBinding>() {

    override fun DIFF_CALLBACK() = object : DiffUtil.ItemCallback<Biomarker>() {
        override fun areItemsTheSame(oldItem: Biomarker, newItem: Biomarker): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Biomarker, newItem: Biomarker): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: Companion.BaseViewHolder<BiomarkerListItemBinding>, position: Int) {
        val biomarkerItem = differ.currentList[position]

        with(holder.binding) {
            root.animation = AnimationUtils.loadAnimation(root.context, R.anim.biomarker_list_item_animation)
            root.rootView.setOnClickListener {
                listener?.invoke(biomarkerItem, this)
            }
            ViewCompat.setTransitionName(biomarkerLayout.biomarkerLayout, "biomarkerLayout_${biomarkerItem.symbol}_${biomarkerItem.id}")
            biomarker = differ.currentList[position]
        }
    }

    override fun getLayout() = R.layout.biomarker_list_item
}
