package com.example.notetaker.ui.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetaker.data.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    // State
    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask = _selectedTask

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading

    // get task by id
    private fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            TODO("get task from repository")
        }
    }

    // add new task
    private fun addTask(taskToAdd: Task) {
        viewModelScope.launch {
            _isLoading.value = true
            // repository.addTask(taskToAdd)
        }
    }
    // update a task
    private fun updateTask(taskToUpdate: Task) {
        viewModelScope.launch {
            _isLoading.value = true
            // repository.updateTask(taskToUpdate)
        }
    }
    // remove a task
    private fun removeTask(taskToRemove: Task) {
        viewModelScope.launch {
            _isLoading.value = true
            // repository.removeTask(taskToRemove)
        }

    }
}