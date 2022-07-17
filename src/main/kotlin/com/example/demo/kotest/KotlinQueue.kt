package com.example.demo.kotest

class KotlinQueue: MyList {

    private val elements: MutableList<Int> = mutableListOf()

    override fun push(ele: Int) {
        elements.add(ele)
    }

    override fun pop(): Int {
        if (elements.size <= 0) {
            throw RuntimeException()
        }
        return elements.removeFirst()
    }

    override fun size(): Int {
        return elements.size
    }

    override fun asList(): List<Int> {
        return elements.toList()
    }

    override fun clean() {
        elements.clear()
    }

}