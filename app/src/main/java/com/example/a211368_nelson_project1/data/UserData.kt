package com.example.a211368_nelson_project1.data

data class UserData(
    val name: String = "",
    val experiment: String = "",
    val note: String = "",

    val email: String = "",
    val age: String = "",
    val className: String = ""
)

data class ExperimentDetail(
    val title: String,
    val description: String,
    val objective: String,
    val materials: String,
    val steps: String
)

