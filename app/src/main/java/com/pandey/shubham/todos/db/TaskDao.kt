package com.pandey.shubham.todos.db


import androidx.room.*
import com.pandey.shubham.todos.model.Task
import kotlinx.coroutines.flow.Flow

/**
 * @author Shubham Pandey
 */

//@Dao
//interface TaskDao {
//
//    @Insert(entity = Task::class, onConflict = OnConflictStrategy.REPLACE)
//    fun saveTask(task: Task)
//
//    @Delete
//    fun deleteTask(task: Task)
//
//    @Query("SELECT * FROM task")
//    fun getAllTasks(): Flow<List<Task>>
//}