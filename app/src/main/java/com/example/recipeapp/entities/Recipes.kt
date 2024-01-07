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
    val category: String,
//  number of servings
    @ColumnInfo(name = "serves")
    var serves:String,
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