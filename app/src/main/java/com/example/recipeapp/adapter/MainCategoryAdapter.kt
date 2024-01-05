package com.example.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.databinding.ItemRecyclerMainCategoryBinding
import com.example.recipeapp.entities.CategoryItems

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var ctx: Context? = null
    var arrayMainCategory = ArrayList<CategoryItems>()
    class RecipeViewHolder(
        val binding: ItemRecyclerMainCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(arrData: List<CategoryItems>){
        arrayMainCategory = arrData as ArrayList<CategoryItems>
    }

    fun setClickListener(l1: OnItemClickListener){
        listener = l1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ctx = parent.context
        val binding = ItemRecyclerMainCategoryBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.dishName.text = arrayMainCategory[position].strcategory

        Glide.with(ctx!!).load(arrayMainCategory[position].strcategorythumb).into(holder.binding.imgDish)
        holder.binding.root.setOnClickListener {
            listener!!.onClicked(arrayMainCategory[position].strcategory)
        }
    }

    interface OnItemClickListener{
        suspend fun OnClicked(caegoryName: String)
    }
}