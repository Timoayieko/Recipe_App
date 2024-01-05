package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

@Dao
interface RecipeDao {
//    @get:Query(value = "SELECT * FROM recipes ORDER BY id DESC")
//    val allRecipes: List<Recipes>
    @get:Query(value = "SELECT * FROM category ORDER BY id DESC")
    val getAllCategories: List<Category>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun  insertRecipe(recipe: Recipes)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  insertCategory(category: Category)
    // TODO: SQL functions 
}