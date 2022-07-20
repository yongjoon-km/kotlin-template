package com.example.demo.kotest

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class Person(var age: Int)

class MyCoroutine {

    suspend fun test(): List<Int> {

        val list: MutableList<Int> = mutableListOf()

        coroutineScope {
            launch {
                delayAndAdd(list)
            }
            list.add(1)
        }

        return list
    }

    suspend fun changeState(p: Person) {
        coroutineScope {
            launch {
                p.age = 5
                delay(1000L)
                p.age = 6
            }
        }
    }

    suspend fun delayAndAdd(list: MutableList<Int>) {
        delay(5000L)
        list.add(2)
    }

}