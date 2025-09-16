package com.example.helloworldcir.data

import com.example.helloworldcir.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.Clock

class UserRepository {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    fun addUser(name: String) {
        if (name.isNotBlank()) {
            val newUser = User(
                id = Clock.System.now().toEpochMilliseconds().toString(),
                name = name.trim()
            )
            _users.value = _users.value + newUser
        }
    }

    fun removeUser(userId: String) {
        _users.value = _users.value.filterNot { it.id == userId }
    }
}