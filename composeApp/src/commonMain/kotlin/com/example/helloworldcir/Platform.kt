package com.example.helloworldcir

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform