package com.pandey.shubham.todos.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pandey.shubham.todos.repository.TaskRepository

/**
 * @author Shubham Pandey
 */
class TaskListViewModelFactory(private val repository: TaskRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskListViewModel::class.java)) {
            return TaskListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}