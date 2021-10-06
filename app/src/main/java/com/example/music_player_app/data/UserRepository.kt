package com.example.music_player_app.data

import androidx.lifecycle.LiveData

class UserRepository (private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user:User) {
        userDao.addUser(user)
    }
}

//Класс, который абстрагирует доступ к множественным источникам информации
//Репозиторий нужен для более чистого кода и вообще признак хорошего тона