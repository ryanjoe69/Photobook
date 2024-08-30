package com.example.myapplication2

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [UserClass::class], version = 1)

    abstract class AppDatabase : RoomDatabase() {
        abstract fun userDAO() : UserDAO


        companion object {
            @Volatile
            private var INSTANCE: AppDatabase? = null

            fun getDatabase (context: Context): AppDatabase {
                return INSTANCE ?:synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "User_Database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                instance
                }
        }
            fun insert(firstname: String, lastname: String, password: String, id: Int): Any {
                val user = UserClass(id,firstname, lastname, password)
                return user
            }
        }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }
}






