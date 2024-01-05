package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.ItemRecyclerSubCategoryBinding
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var arraySubCategory = ArrayList<Recipes>()
    class RecipeViewHolder(
        val binding: ItemRecyclerSubCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(arrData: ArrayList<Recipes>){
        arraySubCategory = arrData as ArrayList<Recipes>
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerSubCategoryBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arraySubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.dishName.text = arraySubCategory[position].dishName
    }
}