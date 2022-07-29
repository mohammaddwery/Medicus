package com.medicus.app.presentation.biomarkers

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
            return oldItem.equals(newItem)
        }
    }

    override fun onBindViewHolder(holder: Companion.BaseViewHolder<BiomarkerListItemBinding>, position: Int) {
        with(holder.binding) {
            root.rootView.setOnClickListener {
                val biomarker = differ.currentList[position]
                listener?.invoke(biomarker, this)
            }
            biomarker = differ.currentList[position]
        }
    }

    override fun getLayout() = R.layout.biomarker_list_item

}
