package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

@Dao
interface RecipeDao {
    @get:Query(value = "SELECT * FROM recipes ORDER BY id DESC")
    val allRecipes: List<Recipes>

    @get: Query(value = "SELECT * FROM recipes WHERE category = 1 ORDER BY id DESC")
    val allBreakfast: List<Recipes>

    @get: Query(value = "SELECT * FROM recipes WHERE category = 2 ORDER BY id DESC")
    val allLunch: List<Recipes>

    @get: Query(value = "SELECT * FROM recipes WHERE category = 3 ORDER BY id DESC")
    val allSupper: List<Recipes>

    @get: Query(value = "SELECT * FROM recipes WHERE category = 4 ORDER BY id DESC")
    val allSnack: List<Recipes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  insertRecipe(recipe: Recipes)

}