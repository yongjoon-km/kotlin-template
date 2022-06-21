package com.example.demo.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient(name="json", url="https://jsonplaceholder.typicode.com")
interface JSONPlaceHolderClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/todos/{id}"])
    fun getTodo(@PathVariable("id") id: Long): Todo
}

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)