package com.vinsguru.protobuf

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.google.protobuf.Int32Value
import com.vinsguru.json.JPerson
import com.vinsguru.models.Person

fun main(args: Array<String>) {
    //Json
    val person = JPerson("sam", 10)
    val mapper = ObjectMapper().registerModule(KotlinModule())
    val json =  Runnable {
        val bytes = mapper.writeValueAsBytes(person)
        val person1 = mapper.readValue(bytes, JPerson::class.java)
    }

    //protobuff
    val sam = Person.newBuilder()
        .setName("sam")
        .setAge(Int32Value.newBuilder().setValue(10).build())
        .build()

    val proto =  Runnable {
        val bytes = sam.toByteArray()
        val sam1 = Person.parseFrom(bytes)
    }

    for (i in (1 .. 5)) {
        runPerformanceTest(json, "JSON")
        runPerformanceTest(proto, "PROTO")
    }

}

fun runPerformanceTest(runnable: Runnable, method: String) {
    val time1 = System.currentTimeMillis()
    for (a in (0 .. 5_000_000)) {
        runnable.run()
    }
    val time2 = System.currentTimeMillis()
    println("$method : (${time2 - time1}) ms")
}