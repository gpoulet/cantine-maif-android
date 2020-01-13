package io.poulet.cantinemaif.repository

import io.poulet.cantinemaif.model.Stand
import io.poulet.cantinemaif.retrofit.RetrofitClient
import org.jsoup.Jsoup
import java.lang.Exception

class MenuRepository {

    var client = RetrofitClient().webService

    suspend fun getMenu(): List<Stand> {

        try {
            val menu = client.getMenu()
            val parsedHtml = Jsoup.parse(menu.string())
            val body = parsedHtml.body()
            val zoneApercu = body.getElementsByClass("ZoneApercu")
            val elements = zoneApercu.select("div.Element")

            val stands : List<Stand> = elements.map {
                it.children().map { child -> child.text() }
            }.map {
                val title = it[0]
                val meals = it.subList(1, it.size)
                Stand(title, meals)
            }

            return stands

        } catch (e: Exception){

        }

        return emptyList()
    }

}