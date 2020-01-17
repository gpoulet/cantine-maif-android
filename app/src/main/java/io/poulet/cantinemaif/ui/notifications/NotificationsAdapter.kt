package io.poulet.cantinemaif.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import io.poulet.cantinemaif.R
import io.poulet.cantinemaif.model.Notification
import kotlinx.android.synthetic.main.switch_item.view.*

class NotificationsAdapter(val notifications: List<Notification>, val listener: CompoundButton.OnCheckedChangeListener) : RecyclerView.Adapter<StandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandViewHolder {
        return StandViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.switch_item, parent, false))
    }

    override fun getItemCount(): Int = notifications.size

    override fun onBindViewHolder(holder: StandViewHolder, position: Int) {
        val notification = notifications[position]
        holder.label.text = notification.day.value
        holder.switch.isChecked = notification.value
        holder.switch.setOnCheckedChangeListener(listener)
    }

}

class StandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var label: TextView = itemView.switch_label
    var switch: SwitchCompat = itemView.switch_input

}