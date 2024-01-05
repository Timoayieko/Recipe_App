package com.example.recipeapp.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity( tableName = "Recipes")
data class Recipes(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    // TODO: add other attributes
    @ColumnInfo(name = "dishName")
    var dishName:String,

    @ColumnInfo(name = "categoryName")
    var categoryName: String
): Serializable