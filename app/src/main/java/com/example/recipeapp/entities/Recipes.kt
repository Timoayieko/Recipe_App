package com.example.recipeapp.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "Recipes")
data class Recipes(
    @PrimaryKey(autoGenerate = true)
    var id:Int
)