package com.example.iatodolist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.iatodolist.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<Task>>

    @Insert
    suspend fun insertTask(task: Task)
}