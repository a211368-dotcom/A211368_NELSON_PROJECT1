package com.example.a211368_nelson_project1.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.a211368_nelson_project1.data.UserData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class LabViewModel : ViewModel() {

    var userData by mutableStateOf(UserData())
        private set

    var lastUpdated by mutableStateOf("")
        private set

    val noteHistory = mutableStateListOf<String>()

    var profileEmail by mutableStateOf("")
    var profileAge by mutableStateOf("")
    var profileClass by mutableStateOf("")
    var profileImage by mutableStateOf("")
    var isLoggedIn by mutableStateOf(false)

    var isSubmitted by mutableStateOf(false)
        private set

    fun setName(name: String) {
        userData = userData.copy(name = name)
    }

    fun setExperiment(exp: String) {
        userData = userData.copy(experiment = exp)
    }

    fun updateExperiment(title: String) { userData = userData.copy(experiment = title)}
    fun updateUserName(name: String) {
        userData = userData.copy(name = name)
    }

    fun updateNote(note: String) {
        userData = userData.copy(note = note)
        noteHistory.add(note)
        lastUpdated = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()).format(Date())
    }

    fun submitName(name: String) {
        userData = userData.copy(name = name)
        isSubmitted = true
    }

    fun updateProfile(email: String, age: String, className: String) {
        userData = userData.copy(
            email = email,
            age = age,
            className = className,
        )
    }

    fun updateProfileImage(image: String) {
        userData = userData.copy()
        profileImage = image
    }

    fun login(name: String) {
        userData = userData.copy(name = name)
        isLoggedIn = true
    }
}