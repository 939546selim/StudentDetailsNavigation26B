package com.ahona.studentdetailsnavigation26b.data.model.repository



import com.ahona.studentdetailsnavigation26b.data.model.Student

class StudentRepository {

    private val students = listOf(
        Student(
            id = 101,
            name = "Rahul Das",
            course = "Android Development",
            age = 22
        ),
        Student(
            id = 102,
            name = "Priya Sharma",
            course = "Kotlin Development",
            age = 21
        ),
        Student(
            id = 103,
            name = "Amit Roy",
            course = "Java Development",
            age = 23
        )
    )

    fun getAllStudents(): List<Student> {
        return students
    }

    fun getStudentById(studentId: Int): Student? {
        return students.find { student ->
            student.id == studentId
        }
    }
}