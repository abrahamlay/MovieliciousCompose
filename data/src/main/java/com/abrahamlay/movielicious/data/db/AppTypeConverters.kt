//package com.abrahamlay.movielicious.data.db
//
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
//
//
///**
// * Created by Abraham Lay on 27/04/20.
// */
//class AppTypeConverters {
//
//    @TypeConverter
//    fun stringToListInt(
//        string: String
//    ): List<Int> {
//        val listType: Type = object : TypeToken<List<Int>?>() {}.type
//        return Gson().fromJson(string, listType)
//    }
//
//    @TypeConverter
//    fun listIntToString(
//        list: List<Int>?
//    ): String = Gson().toJson(list)
//
//}