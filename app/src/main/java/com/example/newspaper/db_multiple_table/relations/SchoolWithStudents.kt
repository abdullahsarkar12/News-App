package com.example.newspaper.db_multiple_table.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.newspaper.db_multiple_table.entities.School
import com.example.newspaper.db_multiple_table.entities.Student

data class SchoolWithStudents(
    /* School have multiple instance of student,
    For that embedded must used in front of school variable */
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
