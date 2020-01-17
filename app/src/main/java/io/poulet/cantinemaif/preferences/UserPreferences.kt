package io.poulet.cantinemaif.preferences

import android.content.Context
import io.poulet.cantinemaif.model.EnumDay

const val NOTIFICATIONS = "NOTIFICATIONS"
const val TIME = "TIME"

object UserPreferences {

    fun getNotificationsActived(context: Context): Boolean {
        val settings = context.getSharedPreferences(NOTIFICATIONS, 0)
        return settings.getBoolean(NOTIFICATIONS, false)
    }

    fun setNotificationsActived(context: Context, value: Boolean) {
        val settings = context.getSharedPreferences(NOTIFICATIONS, 0)
        settings.edit().putBoolean(NOTIFICATIONS, value).apply()
    }

    fun getDay(context: Context, day: EnumDay): Boolean {
        val settings = context.getSharedPreferences(NOTIFICATIONS, 0)
        return settings.getBoolean(day.value, false)
    }

    fun setDay(context: Context, day: EnumDay, value: Boolean) {
        val settings = context.getSharedPreferences(NOTIFICATIONS, 0)
        settings.edit().putBoolean(day.value, value).apply()
    }

    fun getTime(context: Context): String? {
        val settings = context.getSharedPreferences(NOTIFICATIONS, 0)
        return settings.getString(TIME, "11:30")
    }

    fun setTime(context: Context, value: String) {
        val settings = context.getSharedPreferences(NOTIFICATIONS, 0)
        settings.edit().putString(TIME, value).apply()
    }

}