package com.abasyn.foodify.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abasyn.foodify.R
import com.abasyn.foodify.domain.FoodModel

class HomeViewModel : ViewModel() {

    // First RecyclerView = Foods
    private val _foodList = MutableLiveData<List<FoodModel>>()
    val foodList: LiveData<List<FoodModel>> = _foodList

    // Second RecyclerView = Fast Foods
    private val _fastFoodList = MutableLiveData<List<FoodModel>>()
    val fastFoodList: LiveData<List<FoodModel>> = _fastFoodList

    //Third RecyclerView = COld Drink g
    private val _cdList = MutableLiveData<List<FoodModel>>()  // lowercase
    val cdList: LiveData<List<FoodModel>> = _cdList           // public getter

    init {
        loadFood()
        loadFastFoods()
        loadCD()
    }

    private fun loadFood() {
        _foodList.value = listOf(
            FoodModel(R.drawable.fish, "Food", "Fish"),
            FoodModel(R.drawable.kabab, "Food", "Seekh Kabab"),
            FoodModel(R.drawable.grilledchicken, "Food", "Grilled Chicken"),
            FoodModel(R.drawable.meet, "Food", "Karahi"),
            FoodModel(R.drawable.chickenbiryani, "Food", "Chicken Biryani"),
            FoodModel(R.drawable.beefbiryani, "Food", "Beef Biryani"),
            FoodModel(R.drawable.muttonbiryani, "Food", "Mutton Biryani"),
            FoodModel(R.drawable.sindhibiryani, "Food", "Sindhi Biryani"),
            FoodModel(R.drawable.hyderabadibiryani, "Food", "Hyderabadi Biryani"),
            FoodModel(R.drawable.vegetablebiryani, "Food", "Vegetable Biryani"),
            FoodModel(R.drawable.eggbiryani, "Food", "Egg Biryani"),
            FoodModel(R.drawable.fishbiryani, "Food", "Fish Biryani"),
            FoodModel(R.drawable.tikkabiryani, "Food", "Tikka Biryani"),
            FoodModel(R.drawable.grilledfish, "Food", "Grilled Fish")
        )
    }
    private fun loadFastFoods() {
        _fastFoodList.value = listOf(
            FoodModel(R.drawable.beefburger, "Fast Food", "Beef Burger"),
            FoodModel(R.drawable.chickenburger,"Fast Food","Chicken Burger"),
            FoodModel(R.drawable.zingerburger,"Fast Food","Zinger Burger"),
            FoodModel(R.drawable.cheesburger,"Fast Food","Chees Burger"),
            FoodModel(R.drawable.bbqburger,"Fast Food","BBQ Burger"),
            FoodModel(R.drawable.dpburger,"Fast Food","Double Patty Burger"),
            FoodModel(R.drawable.vaggieburger,"Fast Food","Vaggie Burger"),
            FoodModel(R.drawable.pizza,"Fast Food","Pizza"),
            FoodModel(R.drawable.shwarma,"Fast Food","Shwarma"),
            FoodModel(R.drawable.fingerchips,"Fast Food","Finger Chips"),
            FoodModel(R.drawable.sandwich,"Fast Food","SandWich")
        )
    }
    private fun loadCD() {
        _cdList.value = listOf(
            FoodModel(R.drawable.sevenup,"Cold Drinks","7UP"),
            FoodModel(R.drawable.sting,"Cold Drinks","Sting"),
            FoodModel(R.drawable.fanta,"Cold Drinks","Fanta"),
            FoodModel(R.drawable.cocacola,"Cold Drinks","Coca-Cola"),
            FoodModel(R.drawable.pepsi,"Cold Drinks","Pepsi"),
            FoodModel(R.drawable.sprite,"Cold Drinks","Sprite"),
            FoodModel(R.drawable.redbull,"Cold Drinks","RedBull"),
        )
    }

    // 🔥 Add new Fast Food dynamically
    fun addFastFood(food: FoodModel) {
        val current = _fastFoodList.value?.toMutableList() ?: mutableListOf()
        current.add(food)
        _fastFoodList.value = current
    }
}
