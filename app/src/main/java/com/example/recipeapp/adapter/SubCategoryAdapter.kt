package com.example.recipeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.RecipeActivity
import com.example.recipeapp.databinding.ItemRecyclerSubCategoryBinding
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {
    var ctx : Context? = null
    var arraySubCategory = ArrayList<Recipes>()
    class RecipeViewHolder(
        val binding: ItemRecyclerSubCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setData(arrData: ArrayList<Recipes>){
        arraySubCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ctx = parent.context
        val binding = ItemRecyclerSubCategoryBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arraySubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.dishName.text = arraySubCategory[position].dishName

        holder.binding.cardView.setOnClickListener{
            val intent = Intent(ctx, RecipeActivity::class.java).apply {
                putExtra("dishName", arraySubCategory[position].dishName)
                putExtra("category", arraySubCategory[position].category)
                putExtra("serves", arraySubCategory[position].serves)
                putExtra("difficulty", arraySubCategory[position].difficulty)
                putExtra("ingredients", arraySubCategory[position].ingredients)
                putExtra("steps", arraySubCategory[position].steps)
            }
            ctx?.startActivity(intent)
        }
    }
}