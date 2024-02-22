package com.example.notetaker.data

import java.util.Date


data class Task(
    val id: String,
    val title: String,
    val description: String,
    val creationDate: Date,
    val dueDate: Date,
    val isCompleted: Boolean = false
)
