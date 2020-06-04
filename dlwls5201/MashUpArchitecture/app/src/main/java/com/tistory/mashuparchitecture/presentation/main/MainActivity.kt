package com.tistory.mashuparchitecture.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tistory.blackjin.core.util.Logger
import com.tistory.blackjin.domain.interactor.usecases.GetRecentReposUsecase
import com.tistory.mashuparchitecture.R
import com.tistory.mashuparchitecture.mapper.RepoItemMapper
import com.tistory.mashuparchitecture.presentation.search.SearchActivity
import com.tistory.mashuparchitecture.presentation.search.SearchAdapter
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val searchAdapter by lazy { SearchAdapter() }

    private val getRecentReposUsecase: GetRecentReposUsecase by inject()

    private val compositeDisposable = CompositeDisposable()

    private val repoItemMapper: RepoItemMapper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initButton()

        getRecentReposUsecase.get()
            .map {
                it.map {
                    repoItemMapper.mapToView(it)
                }
            }.subscribe({
                Logger.d("getRecentReposUsecase : $it")
                if (it.isNotEmpty()) {
                    showNoRecentText()
                } else {
                    hideNoRecentText()
                }

                searchAdapter.setItems(it)
            }) {
                Logger.e(it.message)
            }.also {
                compositeDisposable.add(it)
            }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun initRecyclerView() {
        rvActivityMainList.adapter = searchAdapter
    }

    private fun initButton() {
        btnActivityMainSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }

    private fun showNoRecentText() {
        tvActivityMainMessage.visibility = View.GONE
    }

    private fun hideNoRecentText() {
        tvActivityMainMessage.visibility = View.VISIBLE
    }
}
