package com.ahona.studentdetailsnavigation26b.navigation

import kotlinx.serialization.Serializable

@Serializable
data object StudentListRoute

@Serializable
data class StudentDetailsRoute(
    val studentId: Int
)