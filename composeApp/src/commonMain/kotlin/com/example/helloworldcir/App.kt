package com.example.helloworldcir

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.example.helloworldcir.ui.theme.HelloWorldTheme
import com.example.helloworldcir.ui.UserScreen

@Composable
@Preview
fun App() {
    HelloWorldTheme {
        UserScreen()
    }
}
