package com.pandey.shubham.todos.addtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pandey.shubham.todos.repository.TaskRepository
import java.lang.IllegalArgumentException

/**
 * @author Shubham Pandey
 */
class AddTaskViewModelFactory(private val repository: TaskRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddTaskViewModel::class.java)) {
            return AddTaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}