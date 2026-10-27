package com.ahona.studentdetailsnavigation26b


import com.ahona.studentdetailsnavigation26b.data.model.repository.StudentRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class StudentRepositoryTest {

    private val repository = StudentRepository()

    @Test
    fun getStudentById_invalidId_returnsNull() {
        val student = repository.getStudentById(999)

        assertNull(student)
    }

    @Test
    fun getStudentById_validId_returnsCorrectStudent() {
        val student = repository.getStudentById(101)

        assertEquals("Rahul Das", student?.name)
    }
}
