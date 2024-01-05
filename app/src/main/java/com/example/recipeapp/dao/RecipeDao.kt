package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.CategoryItems

@Dao
interface RecipeDao {
    @Query(value = "SELECT * FROM category ORDER BY id DESC")
    suspend fun getAllCategories() : List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertCategory(categoryItems: CategoryItems)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()

    @Query("SELECT * from recipes where categoryName = :categoryName ORDER BY id DESC")
    suspend fun getSpecificRecipes(categoryName: String)
}