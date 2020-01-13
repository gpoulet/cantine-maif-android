package io.poulet.cantinemaif.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.poulet.cantinemaif.model.Stand
import io.poulet.cantinemaif.repository.MenuRepository
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

    val repository = MenuRepository()
    private val sdf = SimpleDateFormat("EEEE d MMMM yyyy", Locale.FRANCE)

    val menus = liveData(Dispatchers.IO) {
        val stands = repository.getMenu()
        emit( MenuState(sdf.format(Date()), stands))
    }


}

data class MenuState(val day: String, val stands: List<Stand>)