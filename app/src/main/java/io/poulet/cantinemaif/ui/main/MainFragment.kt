package io.poulet.cantinemaif.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.poulet.cantinemaif.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        viewModel.menus.observe(this, Observer {
            val viewManager = LinearLayoutManager(context)
            val viewAdapter = StandsAdapter(it.stands)
            recyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }

            day.text = it.day
        })

        viewModel.loadMenus()

        button_preferences.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToNotificationsFragment())
        }
    }

}
