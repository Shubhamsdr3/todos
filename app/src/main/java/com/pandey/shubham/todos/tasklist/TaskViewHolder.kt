package com.pandey.shubham.todos.tasklist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pandey.shubham.todos.databinding.ItemTaskViewBinding
import com.pandey.shubham.todos.model.Task

/**
 * @author Shubham Pandey
 */
class TaskViewHolder(private val binding: ItemTaskViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(task: Task) {
        setTitle(task.title)
        setDescription(task.description)
    }

    private fun setDescription(description: String?) {
        if (description.isNullOrEmpty()) {
            binding.description.text = description
            binding.description.visibility = View.VISIBLE
        } else {
            binding.description.visibility = View.GONE
        }
    }

    private fun setTitle(title: String?) {
        if (title.isNullOrEmpty()) {
            binding.title.text = title
            binding.title.visibility = View.VISIBLE
        } else {
            binding.title.visibility = View.GONE
        }
    }
}