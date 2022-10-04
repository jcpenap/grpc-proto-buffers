package com.vinsguru.protobuf

import com.vinsguru.models.Person

fun main(args: Array<String>) {
    val person = Person.newBuilder()
        .setName("sam")
        .setAge(10)
        .build()
    println(person.toString())
}