package com.pandey.shubham.todos.addtask

/**
 * @author Shubham Pandey
 */
sealed class AddTaskViewState {

    object ShowLoader: AddTaskViewState()

    object HideLoader: AddTaskViewState()

    object TaskAdded: AddTaskViewState()

    data class ShowError(val throwable: Throwable): AddTaskViewState()
}