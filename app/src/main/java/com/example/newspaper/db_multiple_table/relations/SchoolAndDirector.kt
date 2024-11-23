package com.example.newspaper.db_multiple_table.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.newspaper.db_multiple_table.entities.Director
import com.example.newspaper.db_multiple_table.entities.School

data class SchoolAndDirector (
    /*For using embedded in front of school variable, all
     school property can be acquire from school table*/
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName",
    )
    val director: Director

)