package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.adapter.MainCategoryAdapter
import com.example.recipeapp.adapter.SubCategoryAdapter
import com.example.recipeapp.database.RecipeDatabase
import com.example.recipeapp.databinding.ActivityExploreBinding
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.CategoryItems
import com.example.recipeapp.entities.Recipes
import kotlinx.coroutines.launch

class ExploreActivity : BaseActivity() {
    private lateinit var binding: ActivityExploreBinding

    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromDb()

        binding.recyclerSubCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        binding.recyclerSubCategory.adapter = subCategoryAdapter
    }

    private val onClicked = object:  MainCategoryAdapter.OnItemClickListener{
        override suspend fun OnClicked(categoryName: String) {
            RecipeDatabase.getDatabase(this@ExploreActivity).recipeDao().getSpecificRecipes(categoryName)
        }
    }

    private fun getDataFromDb(){
        launch{
            this.let {
                var cat = RecipeDatabase.getDatabase(this@ExploreActivity).recipeDao().getAllCategories()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)

                binding.recyclerMainCategory.layoutManager = LinearLayoutManager(this@ExploreActivity, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerMainCategory.adapter = mainCategoryAdapter
            }
        }
    }
}