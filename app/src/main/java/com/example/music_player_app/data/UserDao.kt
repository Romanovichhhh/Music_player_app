package com.example.music_player_app.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //Поведение программы при конфликте добавления
    /* suspend */ fun addUser(user: User) //Модификатор suspend определяет функцию, которая может приостановить свое выполнение и возобновить его через некоторый период времени

    @Query("SELECT * FROM user_data ORDER BY id ASC") //Запрос на вывод всех таблицы, который помещается в список User'ов
    fun readAllData(): LiveData<List<User>>
}

//Дао - содержит все методы для работы с БД