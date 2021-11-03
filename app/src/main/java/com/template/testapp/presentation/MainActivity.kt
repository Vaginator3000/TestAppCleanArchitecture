package com.template.testapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.template.testapp.R
import com.template.testapp.viewModel.MainViewModel
import com.template.testapp.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    //  private val viewBinding:  by viewBinding(R.id.container)
    //  private val viewBinding by viewBinding(Bindi ::bind, R.id.container)

    private val vModel by lazy { ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vModel.resultLive.observe(this, Observer { text ->
            dataTextView.text = text
        })
    }

    override fun onResume() {
        super.onResume()
        setOnClicks()
    }

    private fun setOnClicks() {
        saveNameBtn.setOnClickListener {
            val text = nameEditText.text.toString()
            vModel.saveData(data = text)
        }

        getNameBtn.setOnClickListener {
            vModel.getData()
        }
    }

}