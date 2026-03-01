package com.abasyn.foodify.presentation.next

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abasyn.foodify.R
import com.abasyn.foodify.domain.FoodModel

class NextViewModel : ViewModel() {

    private val _cakeList = MutableLiveData<List<FoodModel>>()
    private val _iceCreamList = MutableLiveData<List<FoodModel>>()
    private val _fruitList = MutableLiveData<List<FoodModel>>()

    val cakeList: LiveData<List<FoodModel>> get() = _cakeList
    val iceCreamList: LiveData<List<FoodModel>> get() = _iceCreamList
    val fruitList: LiveData<List<FoodModel>> get() = _fruitList

    init {
        loadCake()
        loadIceCream()
        loadFruit()
    }

    private fun loadCake() {
        _cakeList.value = listOf(
            FoodModel(R.drawable.blackforestcake,"Cake","Black Forest Cake"),
            FoodModel(R.drawable.buttercake,"Cake", "Butter Cake"),
            FoodModel(R.drawable.carrotcake,"Cake","Carrot Butter"),
            FoodModel(R.drawable.cheescake,"Cake", "Chees Cake"),
            FoodModel(R.drawable.chocolatecake,"Cake","Chocolate Cake"),
            FoodModel(R.drawable.coffeecake,"Cake","Coffee Cake"),
            FoodModel(R.drawable.fruitcake,"Cake","Fruit Cake"),
            FoodModel(R.drawable.pineapplecake,"Cake","Pineapple Cake"),
            FoodModel(R.drawable.redvelvetcake,"Cake","Redvelvet Cake"),
            FoodModel(R.drawable.vanilacake,"Cake","Vanila Cake")
        )
    }

    private fun loadIceCream() {
        _iceCreamList.value = listOf(
            FoodModel(R.drawable.vanilaicecream,"Ice Cream","Vanilla Ice Cream"),
            FoodModel(R.drawable.chocolateicecream,"Ice Cream","Chocolate Ice Cream"),
            FoodModel(R.drawable.strawberryicecream,"Ice Cream","Strawberry Ice Cream"),
            FoodModel(R.drawable.mangoicecream,"Ice Cream","Mango Ice Cream"),
            FoodModel(R.drawable.pistachioice,"Ice Cream","Pistachio Ice Cream"),
            FoodModel(R.drawable.oreoice,"Ice Cream","Oreo Ice Cream"),
            FoodModel(R.drawable.kulfiice,"Ice Cream","Kulfi Ice Cream"),
            FoodModel(R.drawable.butterscotchice,"Ice Cream","Butterscotch Ice Cream"),
            FoodModel(R.drawable.caramelice,"Ice Cream","Caramel Ice Cream"),
            FoodModel(R.drawable.cookiesice,"Ice Cream","Cookies Ice Cream"),
            FoodModel(R.drawable.blueberryice,"Ice Cream","Blueberry Ice Cream"),
            FoodModel(R.drawable.mintchocolateice,"Ice Cream","Mint Chocolate Ice Cream")
        )
    }

    private fun loadFruit() {
        _fruitList.value = listOf(
            FoodModel(R.drawable.apple,"Fruit","Apple"),
            FoodModel(R.drawable.banana,"Fruit","Banana"),
            FoodModel(R.drawable.orange,"Fruit","Orange"),
            FoodModel(R.drawable.peach,"Fruit","Peach"),
            FoodModel(R.drawable.pineapple,"Fruit","PineApple"),
            FoodModel(R.drawable.pomegranate,"Fruit","Pomegranate"),
            FoodModel(R.drawable.redgrapes,"Fruit","Red Grapes"),
            FoodModel(R.drawable.strawberry,"Fruit","Strawberry"),
            FoodModel(R.drawable.watermelaon,"Fruit","Watermelon"),
        )
    }

    // Example: Add dynamically
    fun addCake(food: FoodModel) {
        val current = _cakeList.value?.toMutableList() ?: mutableListOf()
        current.add(food)
        _cakeList.value = current
    }

    fun addIceCream(food: FoodModel) {
        val current = _iceCreamList.value?.toMutableList() ?: mutableListOf()
        current.add(food)
        _iceCreamList.value = current
    }

    fun addFruit(food: FoodModel) {
        val current = _fruitList.value?.toMutableList() ?: mutableListOf()
        current.add(food)
        _fruitList.value = current
    }
}