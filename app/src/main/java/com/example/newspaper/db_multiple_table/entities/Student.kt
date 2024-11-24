package com.example.newspaper.db_multiple_table.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student (
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val semester: Int,
    val schoolName: String,
)