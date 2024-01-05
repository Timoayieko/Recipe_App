package com.example.recipeapp.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.io.Serializable

@Entity( tableName = "Recipes")
data class Recipes(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

//  title
    @ColumnInfo(name = "dishName")
    var dishName:String,
//  type
    @ColumnInfo(name = "category")
    @Relation(
        parentColumn = "category",
        entityColumn = "id")
    val category: Int,
//  number of servings
    @ColumnInfo(name = "serves")
    var serves:Int,
//  difficulty level
    @ColumnInfo(name = "difficulty")
    var difficulty:String,
//  ingredients
    @ColumnInfo(name = "ingredients")
    var ingredients:String,
//  preparation stepa
    @ColumnInfo(name = "steps")
    var steps:String
): Serializable