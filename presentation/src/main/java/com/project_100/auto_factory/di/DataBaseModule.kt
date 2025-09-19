package com.project_100.auto_factory.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.teddy_park.data.database.Database
import com.teddy_park.data.service.DataDao
import com.teddy_park.data.service.NumberDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): Database = Room
        .databaseBuilder(context, Database::class.java, "database.db")
        .addMigrations(MIGRATION_1_2)
        .addMigrations(MIGRATION_2_3)
        .build()

    @Provides
    @Singleton
    fun provideDataDao(database: Database): DataDao = database.dataDao()

    @Provides
    @Singleton
    fun provideUserInfoDao(database: Database): NumberDao = database.numberDao()

}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // user_info_table 생성
        database.execSQL(
            "CREATE TABLE user_info_table (" +
                    "userId INTEGER PRIMARY KEY NOT NULL," +
                    "name TEXT NOT NULL," +
                    "gender INTEGER NOT NULL," +
                    "birthYear INTEGER NOT NULL," +
                    "birthMonth INTEGER NOT NULL," +
                    "birthDay INTEGER NOT NULL," +
                    "birthType INTEGER NOT NULL," +
                    "birthHour INTEGER," +
                    "birthMinute INTEGER" +
                    ")"
        )
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // user_info_table 생성
        database.execSQL(
            "CREATE TABLE number_table (" +
                    "id TEXT PRIMARY KEY NOT NULL," +
                    "number TEXT NOT NULL," +
                    "message TEXT NOT NULL" +
                    ")"
        )
        database.execSQL("DROP TABLE IF EXISTS user_info_table")
    }
}