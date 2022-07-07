package com.pandey.shubham.todos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pandey.shubham.todos.tasklist.TaskListFragment
import com.pandey.shubham.todos.addtask.AddTaskFragment
import com.pandey.shubham.todos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, TaskListFragment.newInstance(), TaskListFragment.TAG)
        }.commitAllowingStateLoss()
    }

    private fun setupListener() {
        binding.fab.setOnClickListener { showAddTaskFragment() }
    }

    private fun showAddTaskFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, AddTaskFragment.newInstance(), AddTaskFragment.TAG)
        }.commitAllowingStateLoss()
    }
}