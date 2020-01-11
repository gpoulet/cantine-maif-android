package io.poulet.cantinemaif.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

    private val sdf = SimpleDateFormat("EEEE d MMMM yyyy", Locale.FRANCE)
    val menus = MutableLiveData<MenuState>()

    fun loadMenus() {
        val stand1 = Stand("Pizzas", listOf("Reine", "4 fromages"))
        val stand2 = Stand("Grillades", listOf("Steack", "Steack hâché", "Jambon"))
        menus.value = MenuState(sdf.format(Date()), listOf(stand1, stand2))
    }

}

data class MenuState(val day: String, val stands: List<Stand>)
data class Stand(val title: String, val meals: List<String>)