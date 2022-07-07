package com.pandey.shubham.todos.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pandey.shubham.todos.databinding.FragmentAddTaskBinding
import com.pandey.shubham.todos.model.Task
import com.pandey.shubham.todos.repository.TaskRepository


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var viewModel: AddTaskViewModel

    companion object {
        const val TAG = "AddTaskFragment"
        fun newInstance() = AddTaskFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupListener()
    }

    private fun setupViewModel() {
        val factory = AddTaskViewModelFactory(TaskRepository())
        viewModel = ViewModelProvider(this, factory)[AddTaskViewModel::class.java]
        viewModel.addTaskViewState.observe(viewLifecycleOwner) { onAddTaskStateChanged(it) }
    }

    private fun onAddTaskStateChanged(state: AddTaskViewState?) {
        when(state) {
            is AddTaskViewState.ShowLoader -> showLoader()
            is AddTaskViewState.HideLoader -> hideLoader()
            is AddTaskViewState.TaskAdded -> onTaskAdded()
            is AddTaskViewState.ShowError -> showError()
            else -> {
                // do nothing
            }
        }
    }

    private fun setupListener() {
        binding.buttonSecond.setOnClickListener { saveTask() }
    }

    private fun saveTask() {
        val title = binding.title.text
        val description = binding.description.text
        if (title.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "Title can't be empty.", Toast.LENGTH_SHORT).show()
            return
        }
        if (description.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "Description can't be empty.", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.saveTask(Task(title = title.toString(), description = description.toString(), isEditing = false, createdAt = System.currentTimeMillis()))
    }

    private fun onTaskAdded() {
        // do nothing
    }

    private fun hideLoader() {
        binding.loader.visibility = View.GONE
    }

    private fun showLoader() {
        binding.loader.visibility = View.VISIBLE
    }

    private fun showError() {
        // do nothing
    }
}