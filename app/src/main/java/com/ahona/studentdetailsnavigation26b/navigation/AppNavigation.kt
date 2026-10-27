package com.ahona.studentdetailsnavigation26b.navigation



import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

import com.ahona.studentdetailsnavigation26b.data.model.repository.StudentRepository
import com.ahona.studentdetailsnavigation26b.ui.screens.StudentDetailsScreen
import com.ahona.studentdetailsnavigation26b.ui.screens.StudentListScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val repository = StudentRepository()

    NavHost(
        navController = navController,
        startDestination = StudentListRoute
    ) {

        composable<StudentListRoute> {

            val students = repository.getAllStudents()

            StudentListScreen(
                students = students,
                onStudentClick = { studentId ->

                    navController.navigate(
                        StudentDetailsRoute(
                            studentId = studentId
                        )
                    )
                }
            )
        }

        composable<StudentDetailsRoute> { backStackEntry ->

            val route = backStackEntry.toRoute<StudentDetailsRoute>()

            StudentDetailsScreen(
                studentId = route.studentId,
                repository = repository,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}