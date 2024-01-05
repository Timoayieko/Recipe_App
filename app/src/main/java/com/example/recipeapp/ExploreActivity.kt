package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.adapter.MainCategoryAdapter
import com.example.recipeapp.adapter.SubCategoryAdapter
import com.example.recipeapp.databinding.ActivityExploreBinding
import com.example.recipeapp.entities.Recipes

class ExploreActivity : BaseActivity() {
    private lateinit var binding: ActivityExploreBinding

    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        test data
        arrMainCategory.add(Recipes(1, "Boiled"))
        arrMainCategory.add(Recipes(2, "Fried"))
        arrMainCategory.add(Recipes(3, "Meat"))
        arrMainCategory.add(Recipes(4, "Vegetables"))
        arrMainCategory.add(Recipes(5, "Beverages"))
        arrMainCategory.add(Recipes(6, "Sweet"))

        mainCategoryAdapter.setData(arrMainCategory)

        arrSubCategory.add(Recipes(1, "Boiled Eggs"))
        arrSubCategory.add(Recipes(2, "Fried Chicken"))
        arrSubCategory.add(Recipes(3, "Stir Fry"))
        arrSubCategory.add(Recipes(4, "Managu"))
        arrSubCategory.add(Recipes(5, "Sweet Tea"))
        arrSubCategory.add(Recipes(6, "Cookies"))

        subCategoryAdapter.setData(arrSubCategory)

        binding.recyclerMainCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerMainCategory.adapter = mainCategoryAdapter

        binding.recyclerSubCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        binding.recyclerSubCategory.adapter = subCategoryAdapter
    }
}