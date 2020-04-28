package com.tistory.blackjin.core.sample

import android.os.Bundle
import com.tistory.blackjin.core.R
import com.tistory.blackjin.core.base.BaseActivity
import com.tistory.blackjin.core.databinding.ActivitySampleBinding
import com.tistory.blackjin.core.sample.base.RecyclerViewFragment
import com.tistory.blackjin.core.sample.live.LiveRecyclerViewFragment
import com.tistory.blackjin.core.sample.simple.SimpleRecyclerViewFragment

class SampleActivity : BaseActivity<ActivitySampleBinding>(R.layout.activity_sample) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.lyt_sample_container, SampleFragment.newInstance())
            .commit()
    }

    fun goToRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, RecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun goToSimpleRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, SimpleRecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun goToLiveRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, LiveRecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
