package com.example.newspaper.db_multiple_table.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.newspaper.db_multiple_table.entities.Student
import com.example.newspaper.db_multiple_table.entities.StudentSubjectCrossRef
import com.example.newspaper.db_multiple_table.entities.Subject

data class StudentWithSubjects (
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        /*Junction use to connect student and subject table*/
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)