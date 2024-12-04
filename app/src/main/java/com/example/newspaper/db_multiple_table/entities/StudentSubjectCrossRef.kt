package com.example.newspaper.db_multiple_table.entities

import androidx.room.Entity

/* In this table there is no primary key,
here we can use both student name and subject name as primary key*/
@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String,
)