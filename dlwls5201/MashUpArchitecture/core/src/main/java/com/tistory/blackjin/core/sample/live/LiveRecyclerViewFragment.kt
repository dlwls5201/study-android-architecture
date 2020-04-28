package com.tistory.blackjin.core.sample.live

import android.os.Bundle
import android.view.View
import com.tistory.blackjin.core.R
import com.tistory.blackjin.core.base.BaseFragment
import com.tistory.blackjin.core.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.core.ext.toast
import com.tistory.blackjin.core.liverecyclerview.bindData
import com.tistory.blackjin.core.sample.data.SampleData

class LiveRecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    companion object {

        fun newInstance() = LiveRecyclerViewFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listSample.bindData(
            SampleData.get("LiveRecyclerViewFragment"),
            R.layout.item_sample,
            viewLifecycleOwner
        ) {
            requireContext().toast(it)
        }
    }
}