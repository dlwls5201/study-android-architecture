package com.tistory.blackjin.core.sample

import android.os.Bundle
import android.view.View
import com.tistory.blackjin.core.R
import com.tistory.blackjin.core.base.BaseFragment
import com.tistory.blackjin.core.databinding.FragmentSampleBinding

class SampleFragment : BaseFragment<FragmentSampleBinding>(R.layout.fragment_sample) {

    companion object {

        fun newInstance() = SampleFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRecyclerView.setOnClickListener {
            (requireActivity() as SampleActivity).goToRecyclerViewFragment()
        }

        binding.btnSimpleRecyclerView.setOnClickListener {
            (requireActivity() as SampleActivity).goToSimpleRecyclerViewFragment()
        }

        binding.btnLiveRecyclerView.setOnClickListener {
            (requireActivity() as SampleActivity).goToLiveRecyclerViewFragment()
        }
    }
}