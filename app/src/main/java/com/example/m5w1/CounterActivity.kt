package com.example.m5w1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.m5w1.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity(), CounterContract {
    private val presenter = CountPresenter()
    private val binding by lazy {ActivityCounterBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachCounterContract(this)

        binding.btnDecrement.setOnClickListener {
            presenter.onDecrement()
            presenter.onTen(this)
            presenter.onFifteen(binding, this)
            presenter.onDifferentNumber(binding, this)
        }

        binding.btnIncrement.setOnClickListener {
            presenter.onIncrement()
            presenter.onTen(this)
            presenter.onFifteen(binding, this)
            presenter.onDifferentNumber(binding, this)
        }
    }

    override fun showResult(count: Int) {
       binding.tvResult.text = count.toString()
    }
}