package com.abasyn.foodify.presentation.next

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.abasyn.foodify.R
import com.abasyn.foodify.domain.FoodModel

class NextAdapter(private var cakeList: List<FoodModel>) :
    RecyclerView.Adapter<NextAdapter.FoodViewHolder>() {

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
        val food = cakeList[position]
        holder.foodImage.setImageResource(food.image)
        holder.foodTitle.text = food.name
        holder.foodDescription.text = food.description
    }

    override fun getItemCount(): Int = cakeList.size

    fun updateList(newList: List<FoodModel>) {
        cakeList = newList
        notifyDataSetChanged()
    }
}