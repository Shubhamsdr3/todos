package com.pandey.shubham.todos.tasklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pandey.shubham.todos.repository.TaskRepository

/**
 * @author Shubham Pandey
 */
class TaskListViewModel(private val taskRepository: TaskRepository): ViewModel() {

    private val taskListMutableViewState: MutableLiveData<TaskListViewState> = MutableLiveData()
    val taskListViewState: LiveData<TaskListViewState> get() = taskListMutableViewState

    fun getAllTasks() {
        taskListMutableViewState.value = TaskListViewState.ShowLoader
        taskListMutableViewState.value = TaskListViewState.ShowTaskList(taskRepository.getAllTasks())
    }
}