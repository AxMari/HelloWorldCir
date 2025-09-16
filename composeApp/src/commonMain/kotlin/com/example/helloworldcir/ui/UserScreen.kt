package com.example.helloworldcir.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import com.example.helloworldcir.data.UserRepository
import com.example.helloworldcir.presentation.*
import androidx.compose.ui.text.input.ImeAction



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen() {
    val store = remember { UserStore(UserRepository()) }
    val users by store.users.collectAsState()
    val state by store.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User Management") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Input field
            OutlinedTextField(
                value = state.input,
                onValueChange = { store.dispatch(UserIntent.UpdateInput(it)) },
                label = { Text("Enter name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { store.dispatch(UserIntent.AddUser(state.input)) }
                )
            )
            Button(
                onClick = { store.dispatch(UserIntent.AddUser(state.input)) },
                enabled = state.input.isNotBlank(), // only active when there's text
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Add User")
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(users) { user ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(user.name)

                        IconButton(onClick = { store.dispatch(UserIntent.RemoveUser(user.id)) }) {
                            Text(
                                "X",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }
}