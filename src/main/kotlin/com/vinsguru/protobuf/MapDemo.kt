package com.vinsguru.protobuf

import com.vinsguru.models.Car
import com.vinsguru.models.Dealer

fun main(args: Array<String>) {

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

    val dealer = Dealer.newBuilder()
        .putModel(2005, civic)
        .putModel(2020, accord)
        .build()

    println(dealer.modelMap)

}