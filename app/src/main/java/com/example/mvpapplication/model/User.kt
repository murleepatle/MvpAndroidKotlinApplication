package com.example.mvpapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey var username: String,
        var name: String,
        var email: String,
        var password: String,
        var mobile: String,
        var address:String,
)