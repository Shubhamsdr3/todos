package com.pandey.shubham.todos.db


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pandey.shubham.todos.App
import com.pandey.shubham.todos.model.Task

/**
 * @author Shubham Pandey
 */

//@Database(entities = [Task::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun taskDao() : TaskDao
//
//    companion object {
//
//        private const val DATABASE = "todo"
//
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        @JvmStatic
//        fun getInstance(): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(App().applicationContext, AppDatabase::class.java, DATABASE)
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}