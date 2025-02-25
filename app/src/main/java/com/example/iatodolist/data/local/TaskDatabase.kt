package com.example.iatodolist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.iatodolist.data.model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}