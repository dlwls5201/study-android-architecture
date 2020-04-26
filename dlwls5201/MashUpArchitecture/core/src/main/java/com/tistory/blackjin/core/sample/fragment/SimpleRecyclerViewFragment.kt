package com.tistory.blackjin.core.sample.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tistory.blackjin.core.BR
import com.tistory.blackjin.core.R
import com.tistory.blackjin.core.base.BaseFragment
import com.tistory.blackjin.core.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.core.databinding.ItemSampleBinding
import com.tistory.blackjin.core.ext.toast
import com.tistory.blackjin.core.liverecyclerview.bindData
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

        binding.listSample.bindData(SampleData.get("SimpleRecyclerViewFragment"), R.layout.item_sample, viewLifecycleOwner)
    }
}