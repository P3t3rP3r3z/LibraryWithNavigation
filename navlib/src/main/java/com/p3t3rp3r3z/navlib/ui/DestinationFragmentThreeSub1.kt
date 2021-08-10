package com.p3t3rp3r3z.navlib.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.p3t3rp3r3z.navlib.R

/**
 * A simple [Fragment] subclass.
 * Use the [DestinationFragmentThreeSub1.newInstance] factory method to
 * create an instance of this fragment.
 */
class DestinationFragmentThreeSub1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination_three_sub1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(DestinationFragmentThreeSub1Directions.actionDestinationFragmentThreeSub1ToDestinationFragmentOne("Nice job!"))
        }
    }
}