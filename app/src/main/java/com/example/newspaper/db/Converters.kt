package com.example.newspaper.db

import androidx.room.TypeConverter
import com.example.newspaper.network.Source

class Converters {
    // Convert a Source object to a String
    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.name
    }

    // Convert a String to a Source object
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)

    }
}

