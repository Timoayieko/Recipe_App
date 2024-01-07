package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipeapp.databinding.ActivityRecipeBinding
import com.example.recipeapp.databinding.ActivitySplashBinding

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        binding.rName.text = intent.getStringExtra("dishName")
        binding.rCategory.text = intent.getStringExtra("category")
        binding.rServes.text = intent.getStringExtra("serves")
        binding.rDifficulty.text = intent.getStringExtra("difficulty")
        binding.rIngredients.text = intent.getStringExtra("ingredients")
        binding.rSteps.text = intent.getStringExtra("steps")
    }
}