package com.pandey.shubham.todos.addtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandey.shubham.todos.repository.TaskRepository
import com.pandey.shubham.todos.model.Task
import kotlinx.coroutines.launch

/**
 * @author Shubham Pandey
 */
class AddTaskViewModel(private val repository: TaskRepository): ViewModel() {

    private val addTaskViewMutableViewState: MutableLiveData<AddTaskViewState> = MutableLiveData()
    val addTaskViewState: LiveData<AddTaskViewState> get() = addTaskViewMutableViewState

    fun saveTask(task: Task) {
        addTaskViewMutableViewState.value = AddTaskViewState.ShowLoader
        viewModelScope.launch {
            try {
                repository.saveTask(task)
                addTaskViewMutableViewState.value = AddTaskViewState.HideLoader
                addTaskViewMutableViewState.value = AddTaskViewState.TaskAdded
            } catch (e: Exception) {
                addTaskViewMutableViewState.value = AddTaskViewState.HideLoader
                addTaskViewMutableViewState.value = AddTaskViewState.ShowError(e)
            }
        }
    }
}