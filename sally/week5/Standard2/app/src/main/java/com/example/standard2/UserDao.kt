package com.example.standard2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    //실질적 데이터 CRUD

    //삽입
    @Insert
    fun insert(user: User)

    //삭제
    @Delete
    fun delete(user: User)

    //조회회
    @Query("SELECT * FROM User")
    fun selectAll(): List<User>

    @Query("SELECT * FROM User WHERE userId = :userId")
    fun selectByUserId(userId: Int): User

    @Query("SELECT * FROM User WHERE name = :name")
    fun selectByUserName(name: String): List<User>

    //업데이트
    @Query("UPDATE User SET name = :name WHERE userId = :userId")
    fun updateNameByUserId(userId: Int, name: String)

}