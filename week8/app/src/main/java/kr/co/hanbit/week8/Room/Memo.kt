package kr.co.hanbit.week8.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @ColumnInfo(name="memo") val memo: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="memoId") val memoId: Int = 0
)