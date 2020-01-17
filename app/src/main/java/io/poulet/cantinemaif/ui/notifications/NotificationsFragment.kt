package io.poulet.cantinemaif.ui.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager

import io.poulet.cantinemaif.R
import io.poulet.cantinemaif.model.EnumDay
import io.poulet.cantinemaif.model.Notification
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.toolbar_notifications.*


class NotificationsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_back.setOnClickListener {
            activity?.onBackPressed()
        }

        val notifications = listOf(
            Notification(EnumDay.MONDAY, false),
            Notification(EnumDay.TUESDAY, false),
            Notification(EnumDay.WEDNESDAY, false),
            Notification(EnumDay.THURSDAY, false),
            Notification(EnumDay.WEDNESDAY, false)
            )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NotificationsAdapter(notifications, CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->  })
        }
    }


}
