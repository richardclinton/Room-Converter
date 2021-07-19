package com.beanworth.converterapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
@Database(entities = [User::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class MyDatabase: RoomDatabase() {
    abstract val userDao:UserDao
    companion object{
        @Volatile
        private var INSTANCE:MyDatabase? = null

        fun getInstance(context: Context):MyDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "my_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}