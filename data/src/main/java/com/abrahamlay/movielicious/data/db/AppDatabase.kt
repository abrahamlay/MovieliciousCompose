package com.abrahamlay.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.movielicious.data.db.MovieDao

/**
 * Created by Abraham Lay on 27/04/20.
 */
@Database(
    entities = [MovieModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(AppTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}
