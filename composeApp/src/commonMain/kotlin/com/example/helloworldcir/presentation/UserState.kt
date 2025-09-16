package com.example.helloworldcir.presentation

import com.example.helloworldcir.domain.User

data class UserState(
    val users: List<User> = emptyList(),
    val input: String = ""
)