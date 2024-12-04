package com.example.newspaper.db_multiple_table.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newspaper.db_multiple_table.dao.SchoolDao
import com.example.newspaper.db_multiple_table.entities.Director
import com.example.newspaper.db_multiple_table.entities.School
import com.example.newspaper.db_multiple_table.entities.Student
import com.example.newspaper.db_multiple_table.entities.StudentSubjectCrossRef
import com.example.newspaper.db_multiple_table.entities.Subject

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}