package com.example.music_player_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{  //Статическая глобальная переменная, синглтон. Нужна, чтобы существовала только одна сущность БД

    @Volatile //Переменная читается напрямую из памяти, а не из потока. Volatile - решает проблему, когда в нескольких потоков у одной переменной разные значения
    private var INSTANCE: UserDatabase? = null

    fun getDatabase(context: Context) : UserDatabase{
        val tempInstance = INSTANCE
        if(tempInstance != null) { //Если экземляр БД не null, возвращаем экземпляр
            return tempInstance
        }
        synchronized(this) { //Всё внутри блока защищено от одновременного использования несколькими потоками
            val instance = Room.databaseBuilder( //Если всё-таки null, то создаём новый и возвращаем его
                context.applicationContext,
                UserDatabase::class.java,
                "user_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
    }
}

// База данных, основная связь с программой