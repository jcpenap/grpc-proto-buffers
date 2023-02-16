package com.vinsguru.protobuf

import com.vinsguru.models.Credentials
import com.vinsguru.models.EmailCredentials
import com.vinsguru.models.PhoneOTP

fun main(args: Array<String>) {
    val emailCredentials = EmailCredentials.newBuilder()
        .setEmail("nobody@gmail.com")
        .setPassword("admin123")
        .build()

    val phoneOTP = PhoneOTP.newBuilder()
        .setNumber(1231231234)
        .setCode(456)
        .build()

    val credentials = Credentials.newBuilder()
        .setEmailMode(emailCredentials)
        .setPhoneMode(phoneOTP)
        .build()

    OneOfDemo.login(credentials)
}

class OneOfDemo {
    companion object {
        fun login(credentials: Credentials) {
            when(credentials.modeCase) {
                Credentials.ModeCase.EMAILMODE ->   println(credentials.emailMode)
                Credentials.ModeCase.PHONEMODE ->  println(credentials.phoneMode)
            }
        }
    }
}
