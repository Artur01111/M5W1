package com.example.m5w1

class CounterModel {

    private var count = 0

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }

    fun getResult() = count

}