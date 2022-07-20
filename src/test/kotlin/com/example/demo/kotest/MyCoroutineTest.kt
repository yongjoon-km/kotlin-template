package com.example.demo.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest

@ExperimentalCoroutinesApi
class MyCoroutineTest : FunSpec({

    val myCoroutine = MyCoroutine()

    test("run coroutine") {
        runTest {
            val rst = myCoroutine.test()
            rst.size shouldBe 2
            rst[0] shouldBe 1
            rst[1] shouldBe 2
        }
    }

    // does not work as expected
    xtest("test advanced") {
        runTest {
            val p = Person(20)
            p.age shouldBe 20
            myCoroutine.changeState(p)
            p.age shouldBe 5
            advanceTimeBy(1000L)
            p.age shouldBe 6
        }
    }

    // from github issue but does not work
    xtest("example") {
        var state = 0
        fun CoroutineScope.startAsync() = launch {
            state = 1
            delay(1000)
            state = 2
        }

        runTest {
            startAsync()
             state shouldBe 1
            advanceTimeBy(1_000)
             state shouldBe 2
        }
    }

})
