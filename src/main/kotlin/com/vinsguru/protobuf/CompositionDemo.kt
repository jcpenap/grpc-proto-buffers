package com.vinsguru.protobuf

import com.vinsguru.models.Address
import com.vinsguru.models.Car
import com.vinsguru.models.Person

fun main(args: Array<String>) {

    val address = Address.newBuilder()
        .setPostbox(123)
        .setStreet("main street")
        .setCity("Atlanta")
        .build()

    val car = Car.newBuilder()
        .setMake("Honda")
        .setModel("Accord")
        .setYear(2020)
        .build()

    val juan = Person.newBuilder()
        .setName("Juan")
        .setAge(37)
        .setAddress(address)
        .setCar(car)
        .build()

    println(juan)

}