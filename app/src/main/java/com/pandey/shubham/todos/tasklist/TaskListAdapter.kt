package com.pandey.shubham.todos.tasklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pandey.shubham.todos.databinding.ItemTaskViewBinding
import com.pandey.shubham.todos.model.Task

/**
 * @author Shubham Pandey
 */
class TaskListAdapter(private val taskList: List<Task>) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            holder.bindData(taskList[position])
        }
    }

    override fun getItemCount() = taskList.count()
}