package com.example.helloworldcir.presentation

sealed class UserIntent {
    data class AddUser(val name: String) : UserIntent()
    data class RemoveUser(val userId: String) : UserIntent()
    data class UpdateInput(val value: String) : UserIntent()
}