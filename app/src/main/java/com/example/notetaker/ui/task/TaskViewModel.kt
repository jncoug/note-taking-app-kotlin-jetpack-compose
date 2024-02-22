package com.example.notetaker.ui.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notetaker.data.Task

class TaskViewModel: ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    // add new task by adding to value
    private fun addTask(taskToAdd: Task) {
        val currentTasks = _tasks.value ?: emptyList()
        val updatedTasks = currentTasks + taskToAdd
        _tasks.value = updatedTasks
    }
    // update a task by mapping and updated the matching id
    private fun updateTask(taskToUpdate: Task) {
        val currentTasks = _tasks.value ?: emptyList()
        val updatedTasks = currentTasks.map { if (it.id==taskToUpdate.id) taskToUpdate else it }
        _tasks.value = updatedTasks
    }
    // remove a task by filtering out the id
    private fun removeTask(taskToRemove: Task) {
        val currentTasks = _tasks.value ?: emptyList()
        val updatedTasks = currentTasks.filterNot { it.id==taskToRemove.id }
        _tasks.value = updatedTasks
    }
}