package com.example.iatodolist.ui.screens.tasklist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.iatodolist.ui.components.SimpleButton
import com.example.iatodolist.ui.components.SimpleTextField
import com.example.iatodolist.ui.components.TaskItem
import com.example.iatodolist.data.model.Task

@Composable
fun TaskListScreen(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    val viewModel: TaskViewModel = hiltViewModel()
    val tasks = viewModel.tasks.collectAsState(initial = emptyList())

    Column(modifier = modifier.padding(16.dp)) {
        SimpleTextField(
            text = text,
            label = "Nova Tarefa",
            onValueChange = { text = it }
        )

        SimpleButton("Adicionar tarefa") {
            viewModel.addTask(Task(text = text))
            text = ""
        }

        LazyColumn {
            items(tasks.value) { task ->
                TaskItem(task.text)
            }
        }
    }
}