package com.example.newspaper.db_multiple_table.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "director")
data class Director (
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String
)