package edu.msudenver.cs3013.navigationdrawer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MenuFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var chromaticTunerButton: Button
//    private lateinit var metronomeButton: Button
//    private lateinit var tabsButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the navigation controller
        navController = Navigation.findNavController(view)

        // Initialize the buttons
        chromaticTunerButton = view.findViewById(R.id.btnChromaticTuner)
//        metronomeButton = view.findViewById(R.id.btnMetronome)
//        tabsButton = view.findViewById(R.id.btnTabs)

        // Set click listeners for the buttons
        chromaticTunerButton.setOnClickListener {
            navController.navigate(R.id.nav_chromatic_tuner)
        }

//        metronomeButton.setOnClickListener {
//            navController.navigate(R.id.nav_metronome)
//        }
//
//        tabsButton.setOnClickListener {
//            navController.navigate(R.id.nav_tabs)
//        }
    }
}

