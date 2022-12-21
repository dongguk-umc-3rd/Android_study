package com.example.week8_standardmisssion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun UserDao():UserDao
    //하나의 data 재사용 ( 전역적 )
    companion object{
        //직접 접근 못하도록 private 사용
        // 함수로 접근하기 때문에 null check 필요
       private var appDatabase: AppDatabase? = null

        //여러 접근 막도록(ex:thread)
        @Synchronized
        //room db는 context 필수
        fun getInstance(context : Context): AppDatabase? {
            if (appDatabase == null){
                synchronized(AppDatabase::class.java){
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}