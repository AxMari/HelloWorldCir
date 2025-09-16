package com.example.helloworldcir.presentation

import com.example.helloworldcir.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UserStore(
    private val repository: UserRepository
) {
    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state

    val users = repository.users

    fun dispatch(intent: UserIntent) {
        when (intent) {
            is UserIntent.AddUser -> {
                repository.addUser(intent.name)
                _state.update { it.copy(input = "") }
            }
            is UserIntent.RemoveUser -> {
                repository.removeUser(intent.userId)
            }
            is UserIntent.UpdateInput -> {
                _state.update { it.copy(input = intent.value) }
            }
        }
    }
}