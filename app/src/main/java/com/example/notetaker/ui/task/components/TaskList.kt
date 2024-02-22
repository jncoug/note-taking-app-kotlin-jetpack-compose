package com.example.notetaker.ui.task.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.notetaker.data.Task
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import java.util.Date


@Composable
fun TaskList(tasks: List<Task>, onTaskClicked: (Task) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.small)
            .padding(4.dp)
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 164.dp)
        ) {
            items(tasks) { task ->
                TaskItem(task = task, onTaskClicked = onTaskClicked)
            }
        }
    }
}

@Preview
@Composable
fun TaskListPreview() {
    val task = Task("004nfd7fbe873gb8","Publish Repository", "I will publish the repository of the Note taking app" +
            "to the github. Make sure to commit all changes and then make it public so that any prospective" +
            "employers can view the files.", Date(), Date()
    )
    val task1 = Task("104nfd7fbe873gb8","Make Edits", "I will publish the repository of the Note taking app" +
            "to the github. Make sure to commit all changes and then make it public so that any prospective" +
            "employers can view the files.", Date(), Date(), isCompleted = true
    )
    val task2 = Task("534nfd7fbe873gb8","Record Video", "I will publish the repository of the Note taking app" +
            "to the github. Make sure to commit all changes and then make it public so that any prospective" +
            "employers can view the files.", Date(), Date()
    )
    val task3 = Task("704nfd7fbe873gb8","Get Hired", "I will publish the repository of the Note taking app" +
            "to the github. Make sure to commit all changes and then make it public so that any prospective" +
            "employers can view the files.", Date(), Date()
    )

    // Preview the TaskItem composable
    TaskList(tasks = (listOf(task, task1, task2, task3)), onTaskClicked = {})
}