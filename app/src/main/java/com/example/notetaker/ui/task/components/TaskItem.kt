package com.example.notetaker.ui.task.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notetaker.data.Task
import java.util.Date

@Composable
fun TaskItem(task: Task, onTaskClicked: (Task) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(MaterialTheme.shapes.small)
            .clickable { onTaskClicked(task) }
            .border(BorderStroke(4.dp, MaterialTheme.colorScheme.secondary))
            .shadow(6.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            
            //task and details
                Row {
                    Text(text = task.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(10.dp))
                    // get icon based on completion
                    val checkBoxIcon = if (task.isCompleted) {
                        Icons.Default.CheckCircle
                    } else {
                        Icons.Default.Build
                    }

                    // display icon
                    Icon(
                        imageVector = checkBoxIcon,
                        contentDescription = null,
                        tint = if (task.isCompleted) Color.Green else Color.Gray
                    )
                }
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp))

            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = task.description, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Due Date: ${task.dueDate}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(16.dp))
            }

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                modifier = Modifier
                    .clickable { // edit the task
               }
            )
        }
        
    }
}

@Preview
@Composable
fun TaskItemPreview() {
    val task = Task("004nfd7fbe873gb8","Publish Repository", "I will publish the repository of the Note taking app" +
            "to the github. Make sure to commit all changes and then make it public so that any prospective" +
            "employers can view the files.", Date(), Date(), isCompleted = false)

    // Preview the TaskItem composable
    TaskItem(task = task) {}
}






