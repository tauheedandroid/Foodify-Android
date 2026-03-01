package com.abasyn.foodify.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.abasyn.foodify.R
import com.abasyn.foodify.domain.FoodModel

class FoodAdapter(private val foodList: List<FoodModel>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val foodImage: ImageView = itemView.findViewById(R.id.imgFood)
        val foodTitle: TextView = itemView.findViewById(R.id.tvFoodName)
        val foodDescription: TextView = itemView.findViewById(R.id.tvFoodDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item, parent, false)

        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]

        holder.foodImage.setImageResource(food.image) // Int drawable
        holder.foodTitle.text = food.name            // String
        holder.foodDescription.text = food.description
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}