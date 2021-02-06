package com.example.yeexcom.ui.findings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.yeexcom.R

class FindingsFragment : Fragment() {

    private lateinit var notificationsViewModel: FindingsViewmodel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(FindingsViewmodel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        return root
    }
}