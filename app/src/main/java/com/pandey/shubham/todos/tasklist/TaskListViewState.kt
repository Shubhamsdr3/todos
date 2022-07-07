package com.pandey.shubham.todos.tasklist

import com.pandey.shubham.todos.model.Task


/**
 * @author Shubham Pandey
 */
sealed class TaskListViewState {

    object ShowLoader: TaskListViewState()

    object HideLoader: TaskListViewState()

    data class ShowError(val throwable: Throwable): TaskListViewState()

    data class ShowTaskList(val taskList: List<Task>):  TaskListViewState()
}