package com.example.demo.kotest

interface MyList {

    fun push(ele: Int)

    fun pop(): Int

    fun size(): Int

    fun asList(): List<Int>

    fun clean()
}
