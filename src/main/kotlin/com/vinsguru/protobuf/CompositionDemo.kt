package com.vinsguru.protobuf

import com.google.protobuf.Int32Value
import com.vinsguru.models.Address
import com.vinsguru.models.Car
import com.vinsguru.models.Person

fun main(args: Array<String>) {

    val address = Address.newBuilder()
        .setPostbox(123)
        .setStreet("main street")
        .setCity("Atlanta")
        .build()

    val accord = Car.newBuilder()
        .setMake("Honda")
        .setModel("Accord")
        .setYear(2020)
        .build()

    val civic = Car.newBuilder()
        .setMake("Honda")
        .setModel("Civic")
        .setYear(2005)
        .build()

    val juan = Person.newBuilder()
        .setName("Juan")
        .setAge(Int32Value.newBuilder().setValue(37).build())
        .setAddress(address)
        .addAllCar(
            listOf(accord, civic)
        )
        .build()

    println(juan)

}