package com.p3t3rp3r3z.navlib.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.p3t3rp3r3z.navlib.R

/**
 * A simple [Fragment] subclass.
 * Use the [DestinationFragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class DestinationFragmentTwo : Fragment() {
    private var param1: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.cool_button)

        button.setOnClickListener {
            val action = DestinationFragmentTwoDirections.actionDestinationFragmentTwoToDestinationFragmentOne("See?! Cool!")
            findNavController().navigate(action)
        }
    }

}