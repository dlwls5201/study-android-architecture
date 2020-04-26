package com.tistory.blackjin.core.sample.fragment

import android.os.Bundle
import android.view.View
import com.tistory.blackjin.core.R
import com.tistory.blackjin.core.base.BaseFragment
import com.tistory.blackjin.core.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.core.ext.toast
import com.tistory.blackjin.core.sample.data.SampleData

class LiveRecyclerViewFragment : BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    companion object {

        fun newInstance() =  LiveRecyclerViewFragment()
    }

    private val recyclerViewAdapter by lazy {
        RecyclerViewAdapter().apply {
            onItemClickListener = object : RecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(data: String) {
                    this@LiveRecyclerViewFragment.requireContext().toast(data)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listSample) {
            adapter = recyclerViewAdapter
        }

        recyclerViewAdapter.replaceAll(SampleData.get("LiveRecyclerViewFragment"))
    }
}