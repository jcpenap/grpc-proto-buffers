package com.vinsguru.protobuf

import com.vinsguru.models.Person

fun main(args: Array<String>) {
    val person = Person.newBuilder().build()

    println("City: ${person.address.city}")
    println(person.hasAddress())
}