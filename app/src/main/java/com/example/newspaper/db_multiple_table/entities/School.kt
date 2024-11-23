package com.example.newspaper.db_multiple_table.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school")
data class School (
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)