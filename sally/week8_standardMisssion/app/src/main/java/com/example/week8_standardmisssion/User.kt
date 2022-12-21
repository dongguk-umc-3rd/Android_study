package com.example.week8_standardmisssion

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name="memo") val memo: String,
    // 고유키 autoGenerate 자동으로 증가
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="memoId") val memoId: Int = 0
)
