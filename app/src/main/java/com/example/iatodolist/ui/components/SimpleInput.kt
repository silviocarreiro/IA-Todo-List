package com.example.iatodolist.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun SimpleTextField(text: String, label: String, onValueChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text("Escreva aqui...") }
    )
}