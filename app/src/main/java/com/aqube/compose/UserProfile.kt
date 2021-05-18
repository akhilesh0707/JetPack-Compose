package com.aqube.compose

data class UserProfile(val name: String, val status: Boolean, val drawable: Int)

val users = mutableListOf(
    UserProfile("John Doe", true, R.drawable.profile_pic),
    UserProfile("Dana Murry", false, R.drawable.profile_pic2),
    UserProfile("Morgen Freeman", false, R.drawable.profile_pic4),
    UserProfile("Dave Dixon", true, R.drawable.profile_pic3),
    UserProfile("John Doe", true, R.drawable.profile_pic),
    UserProfile("Dana Murry", false, R.drawable.profile_pic2),
    UserProfile("Morgen Freeman", false, R.drawable.profile_pic4),
    UserProfile("Dave Dixon", true, R.drawable.profile_pic3),
    UserProfile("Dave Dixon", true, R.drawable.profile_pic3),
    UserProfile("Dave Dixon", true, R.drawable.profile_pic3),
    UserProfile("Dave Dixon", true, R.drawable.profile_pic3)
)