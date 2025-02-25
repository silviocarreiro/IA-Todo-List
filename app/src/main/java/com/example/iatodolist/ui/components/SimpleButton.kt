package com.example.iatodolist.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(texto: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(16.dp)) {
        Text(text = texto)
    }
}