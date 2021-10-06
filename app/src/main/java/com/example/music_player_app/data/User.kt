package com.example.music_player_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val username: String,
    val email: String,
    val password: String
)

// Энтити - буквально таблица БД, где поля класса - столбцы таблицы