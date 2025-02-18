package com.example.iatodolist.ui.screens.tasklist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.iatodolist.data.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> get() = _tasks

    fun addTask(title: String){
        _tasks.add(Task(title))
    }
}