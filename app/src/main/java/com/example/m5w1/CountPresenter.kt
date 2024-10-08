package com.example.m5w1

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.m5w1.databinding.ActivityCounterBinding

class CountPresenter {

    private val model = CounterModel()
    private var counterContract: CounterContract? = null

    fun attachCounterContract(contract: CounterContract){
        this.counterContract = contract
    }

    fun onIncrement(){
        model.increment()
        counterContract?.showResult(model.getResult())
    }

    fun onDecrement(){
        model.decrement()
        counterContract?.showResult(model.getResult())
    }

    fun onTen(context: Context) {
        if (model.getResult() == 10) {
            Toast.makeText(context, "Поздравляем!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onFifteen(binding: ActivityCounterBinding, context: Context) {
        val result = model.getResult()
        if (result == 15) {
            binding.tvResult.setTextColor(ContextCompat.getColor(context, R.color.green))
        }
    }
    fun onDifferentNumber(binding: ActivityCounterBinding, context: Context) {
        val result = model.getResult()
        if (result != 15) {
            binding.tvResult.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }
}