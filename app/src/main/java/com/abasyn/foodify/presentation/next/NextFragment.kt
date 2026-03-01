package com.abasyn.foodify.presentation.next

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abasyn.foodify.R

class NextFragment : Fragment(R.layout.fragment_next) {

    private val viewModel: NextViewModel by viewModels()
    private lateinit var cakeAdapter: NextAdapter
    private lateinit var iceCreamAdapter: NextAdapter
    private lateinit var fruitAdapter: NextAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cake RecyclerView
        val rvcake = view.findViewById<RecyclerView>(R.id.rvCake)
        rvcake.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvcake.setHasFixedSize(true)
        cakeAdapter = NextAdapter(emptyList())
        rvcake.adapter = cakeAdapter
        viewModel.cakeList.observe(viewLifecycleOwner) { list ->
            cakeAdapter.updateList(list)
        }

        // IceCream RecyclerView
        val rvIceCream = view.findViewById<RecyclerView>(R.id.rvIceCream)
        rvIceCream.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvIceCream.setHasFixedSize(true)
        iceCreamAdapter = NextAdapter(emptyList())
        rvIceCream.adapter = iceCreamAdapter
        viewModel.iceCreamList.observe(viewLifecycleOwner) { list ->
            iceCreamAdapter.updateList(list)
        }
        // Fruit RecyclerView
        val rvFruit = view.findViewById<RecyclerView>(R.id.rvFruit)
        rvFruit.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvFruit.setHasFixedSize(true)
        fruitAdapter = NextAdapter(emptyList())
        rvFruit.adapter = fruitAdapter
        viewModel.fruitList.observe(viewLifecycleOwner) { list ->
            fruitAdapter.updateList(list)
    }
}
}