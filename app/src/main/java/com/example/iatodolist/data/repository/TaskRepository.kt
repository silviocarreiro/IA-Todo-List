package com.example.iatodolist.data.repository

import com.example.iatodolist.data.local.TaskDao
import com.example.iatodolist.data.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor (private val taskDao: TaskDao) {
    val allTasks: Flow<List<Task>> = taskDao.getAll()

    suspend fun insert(task: Task){
        taskDao.insertTask(task)
    }
}