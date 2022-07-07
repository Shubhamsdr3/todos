package com.pandey.shubham.todos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Shubham Pandey
 */

@Entity(tableName = "task")
data class Task(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "is_editing") var isEditing: Boolean = false,
    @ColumnInfo(name = "created_at") var createdAt: Long? = null
)

