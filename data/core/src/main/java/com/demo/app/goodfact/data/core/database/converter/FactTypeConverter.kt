package com.demo.app.goodfact.data.core.database.converter

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.demo.app.goodfact.domain.core.model.Fact
import com.google.gson.Gson

@TypeConverters
class FactTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun factToString(fact: Fact): String {
        return gson.toJson(fact)
    }

    @TypeConverter
    fun stringToFact(string: String): Fact? {
        return gson.fromJson(string, Fact::class.java)
    }
}
