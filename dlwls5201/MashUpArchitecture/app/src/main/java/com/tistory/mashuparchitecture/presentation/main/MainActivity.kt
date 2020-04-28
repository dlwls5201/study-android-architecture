package com.tistory.mashuparchitecture.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tistory.blackjin.core.sample.SampleActivity
import com.tistory.mashuparchitecture.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnActivityMainSearch.setOnClickListener {
            //startActivity(Intent(this, SearchActivity::class.java))
            startActivity(Intent(this, SampleActivity::class.java))
        }

    }
}
