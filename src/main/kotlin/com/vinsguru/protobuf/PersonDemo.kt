package com.vinsguru.protobuf

import com.google.protobuf.Int32Value
import com.vinsguru.models.Person
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

fun main(args: Array<String>) {
    val person = Person.newBuilder()
        .setName("sam")
        .setAge(Int32Value.newBuilder().setValue(10).build())
        .build()
    println(person.toString())

    objectToBytes(person)
    bytesToObject()

}

private fun bytesToObject() {
    val path = Path("sam.ser")
    val bytes = Files.readAllBytes(path)
    val newPerson = Person.parseFrom(bytes)
    println(newPerson)
}

private fun objectToBytes(person: Person) {
    val path = Path("sam.ser")
    path.writeBytes(person.toByteArray())
}