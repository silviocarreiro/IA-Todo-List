package com.example.iatodolist.ui.screens.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iatodolist.data.repository.TaskRepository
import com.example.iatodolist.data.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val _tasks = repository.allTasks
    val tasks: Flow<List<Task>> get() = _tasks

    fun addTask(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }
}