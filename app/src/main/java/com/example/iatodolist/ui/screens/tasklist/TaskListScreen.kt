package com.example.iatodolist.ui.screens.tasklist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.iatodolist.ui.components.SimpleButton
import com.example.iatodolist.ui.components.SimpleTextField
import com.example.iatodolist.ui.components.TaskItem
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TaskListScreen(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    val viewModel: TaskViewModel = viewModel()

    Column(modifier = modifier.padding(16.dp)) {
        SimpleTextField(
            text = text,
            label = "Nova Tarefa",
            onValueChange = { text = it }
        )

        SimpleButton("Adicionar tarefa") {
            viewModel.addTask(text)
            text = ""
        }

        LazyColumn {
            items(viewModel.tasks) { task ->
                TaskItem(task.text)
            }
        }
    }
}