package com.pandey.shubham.todos.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pandey.shubham.todos.Constants
import com.pandey.shubham.todos.R
import com.pandey.shubham.todos.databinding.FragmentTaskListBinding
import com.pandey.shubham.todos.model.Task
import com.pandey.shubham.todos.repository.TaskRepository


class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding

    private lateinit var viewModel: TaskListViewModel

    companion object {
        const val TAG = "TaskListFragment"
        fun newInstance() = TaskListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
    }

    private fun setupViewModel() {
        val factory = TaskListViewModelFactory(TaskRepository())
        viewModel = ViewModelProvider(this, factory)[TaskListViewModel::class.java]
        viewModel.getAllTasks()
        viewModel.taskListViewState.observe(viewLifecycleOwner) { onViewStateChanged(it) }
    }

    private fun onViewStateChanged(state: TaskListViewState?) {
        when(state) {
            is TaskListViewState.ShowLoader -> showLoader()
            is TaskListViewState.HideLoader -> hideLoader()
            is TaskListViewState.ShowTaskList -> showTaskList(state.taskList)
            else -> {
                // do nothing
            }
        }
    }

    private fun showTaskList(taskList: List<Task>?) {
        if (!taskList.isNullOrEmpty()) {
            val taskListAdapter = TaskListAdapter(taskList)
            binding.taskList.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            binding.taskList.adapter = taskListAdapter
            binding.taskList.visibility = View.VISIBLE
            binding.textviewFirst.visibility = View.GONE
            binding.image.visibility = View.GONE
        } else {
            binding.textviewFirst.visibility = View.VISIBLE
            binding.image.visibility = View.VISIBLE
        }
    }

    private fun hideLoader() {
        binding.loader.visibility = View.GONE
    }

    private fun showLoader() {
        binding.loader.visibility = View.VISIBLE
    }

    private fun setupView() {
        Glide.with(requireContext()).load(Constants.GIF_URL).into(binding.image)
        binding.textviewFirst.text = getString(R.string.done_text)
    }
}