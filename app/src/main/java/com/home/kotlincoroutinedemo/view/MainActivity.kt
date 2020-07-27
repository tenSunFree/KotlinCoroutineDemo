package com.home.kotlincoroutinedemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.home.kotlincoroutinedemo.common.setGone
import com.home.kotlincoroutinedemo.common.setVisible
import com.home.kotlincoroutinedemo.common.toast
import com.home.kotlincoroutinedemo.databinding.ActivityMainBinding
import com.home.kotlincoroutinedemo.model.MainViewState
import com.home.kotlincoroutinedemo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getViewState().observe(this, Observer { viewState ->
            if (viewState != null) render(viewState)
        })
        viewModel.getData()
    }

    private fun render(viewState: MainViewState) {
        when (viewState) {
            is MainViewState.Loading -> onLoad()
            is MainViewState.Success -> onSuccess(viewState)
            is MainViewState.Error -> onError(viewState)
        }
    }

    private fun onLoad() = with(binding) {
        progressBar.setVisible()
        recyclerView.setGone()
    }

    private fun onSuccess(success: MainViewState.Success) = with(binding) {
        progressBar.setGone()
        recyclerView.apply {
            setVisible()
            val mainAdapter = MainAdapter(success.list)
            mainAdapter.setOnItemClickListener = { toast(it.title) }
            adapter = mainAdapter
        }
    }

    private fun onError(error: MainViewState.Error) = with(binding) {
        progressBar.setGone()
        toast(error.message)
    }
}