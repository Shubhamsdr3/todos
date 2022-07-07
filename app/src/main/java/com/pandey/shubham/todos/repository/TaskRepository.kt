package com.pandey.shubham.todos.repository

import com.pandey.shubham.todos.model.Task

/**
 * @author Shubham Pandey
 */
class TaskRepository {

    private val taskList = mutableListOf<Task>()

    fun saveTask(task: Task) {
        taskList.add(task)
    }

    fun getAllTasks(): List<Task> {
        return taskList
    }

    fun deleteTask(task: Task) {
        taskList.remove(task)
    }
}