package com.example.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.ItemRecyclerSubCategoryBinding
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListener? = null
    var ctx: Context? = null
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
        ctx = parent.context
        val binding = ItemRecyclerSubCategoryBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arraySubCategory.size
    }

    fun setClickListener(l1: SubCategoryAdapter.OnItemClickListener){
        listener = l1
    }
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.dishName.text = arraySubCategory[position].dishName

        holder.itemView.rootView.setOnClickListener{
            listener!!.onClicked(arraySubCategory[position].id.toString())
        }
    }

    interface OnItemClickListener{
        fun onClicked(id:String)
    }
}