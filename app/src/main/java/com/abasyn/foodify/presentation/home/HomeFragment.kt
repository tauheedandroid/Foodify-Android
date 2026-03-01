package com.abasyn.foodify.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abasyn.foodify.R

class HomeFragment: Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvFoods = view.findViewById<RecyclerView>(R.id.rvFood)
        val rvFastFoods = view.findViewById<RecyclerView>(R.id.rvFood2)
        val rvCD = view.findViewById<RecyclerView>(R.id.rvCD)

        // First RecyclerView = Foods
        rvFoods.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvFoods.setHasFixedSize(true)

        // Second RecyclerView = Fast Foods
        rvFastFoods.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvFastFoods.setHasFixedSize(true)

        // Third RecyclerView = Cold Drinks
        rvCD.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvFoods.setHasFixedSize(true)

        // Observe Foods
        viewModel.foodList.observe(viewLifecycleOwner) { list ->
            rvFoods.adapter = FoodAdapter(list)
        }

        // Observe Fast Foods
        viewModel.fastFoodList.observe(viewLifecycleOwner) { list ->
            rvFastFoods.adapter = FoodAdapter(list)
        }

        // Observe Cold Drinks
        viewModel.cdList.observe(viewLifecycleOwner) { list ->
            rvCD.adapter = FoodAdapter(list)
        }
        val tvNext = view.findViewById<TextView>(R.id.tvNext)
        tvNext.setOnClickListener {
            // Navigate to the next fragment
            findNavController().navigate(R.id.action_homeFragment_to_nextFragment)
        }

        // 🔹 Example: Add new Fast Food after 2 sec (optional)
        /*
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.addFastFood(FoodModel(R.drawable.chickenburger, "Burger", "Chicken Burger"))
        }, 2000)
        */
    }
}