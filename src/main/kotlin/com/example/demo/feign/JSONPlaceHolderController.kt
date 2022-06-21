package com.example.demo.feign

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class JSONPlaceHolderController(
    private val jsonPlaceHolderClient: JSONPlaceHolderClient
) {


    @GetMapping("/todos/{id}")
    fun getTodo(@PathVariable("id") id: Long): TodoDto {
        val res = jsonPlaceHolderClient.getTodo(id)
        return TodoDto(res.userId, res.id, res.title, res.completed)
    }
}

data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)