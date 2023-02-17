package com.vinsguru.protobuf

import com.vinsguru.models.Person
import com.vinsguru.models.Television
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

fun main(args: Array<String>) {

    val television = Television.newBuilder()
        .setBrand("sony")
        .setYear(2015)
        .build()

    val path = Path("tv-v1")
    path.writeBytes(television.toByteArray())
    val bytes = Files.readAllBytes(path)
    val newPerson = Person.parseFrom(bytes)
    println(newPerson)

}

class VersionCompatibilityTest {
}