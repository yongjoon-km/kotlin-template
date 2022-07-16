package com.example.demo.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class SortTest : FunSpec({

    context("sort test") {
        data class SortListData(val target: List<Int>, val expected: List<Int>)
        withData(
            nameFn = {"sort ${it.target} then ${it.expected}"},
            SortListData(listOf(5, 2, 4, 3, 1), listOf(1, 2, 3, 4, 5)),
            SortListData(listOf(-1, -5, -2, -3, -4), listOf(-5, -4, -3, -2, -1))
        ) { (target, expected) ->
            target.sorted() shouldBe expected
        }
    }

})
