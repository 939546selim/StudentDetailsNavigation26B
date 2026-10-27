package com.ahona.studentdetailsnavigation26b.ui.screens



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ahona.studentdetailsnavigation26b.data.model.repository.StudentRepository

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun StudentDetailsScreen(
    studentId: Int,
    repository: StudentRepository,
    onBackClick: () -> Unit
) {
    val student = repository.getStudentById(studentId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Student Details")
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            if (student != null) {

                Text(
                    text = student.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Student ID: ${student.id}")

                Text(text = "Course: ${student.course}")

                Text(text = "Age: ${student.age}")

            } else {

                Text(
                    text = "Student not found!",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "No student exists with ID $studentId."
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onBackClick
            ) {
                Text("Back to Student List")
            }
        }
    }
}