package com.tistory.blackjin.core.sample.simple

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.tistory.blackjin.core.BR
import com.tistory.blackjin.core.R
import com.tistory.blackjin.core.base.BaseFragment
import com.tistory.blackjin.core.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.core.databinding.ItemSampleBinding
import com.tistory.blackjin.core.ext.toast
import com.tistory.blackjin.core.sample.data.SampleData
import com.tistory.blackjin.core.simplerecyclerview.SimpleRecyclerViewAdapter
import com.tistory.blackjin.core.simplerecyclerview.SimpleViewHolder

class SimpleRecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    companion object {

        fun newInstance() = SimpleRecyclerViewFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listSample) {
            adapter = object : SimpleRecyclerViewAdapter<String, ItemSampleBinding>(
                R.layout.item_sample,
                BR.model
            ) {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): SimpleViewHolder<ItemSampleBinding> {
                    return super.onCreateViewHolder(parent, viewType).apply {
                        itemView.setOnClickListener {
                            val data = getItem(adapterPosition)
                            this@SimpleRecyclerViewFragment.requireContext().toast(data)
                        }
                    }
                }
            }.apply {
                replaceAll(SampleData.get("SimpleRecyclerViewFragment"))
            }
        }
    }
}