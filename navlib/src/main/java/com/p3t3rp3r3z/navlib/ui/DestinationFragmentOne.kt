package com.p3t3rp3r3z.navlib.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.p3t3rp3r3z.navlib.R
import com.p3t3rp3r3z.navlib.viewmodels.NavGraphViewModel


class DestinationFragmentOne : Fragment() {

    private var arugment: String? = null
    private lateinit var button : Button
    private lateinit var textView : TextView

    val safeArgs : DestinationFragmentOneArgs by navArgs()
    val viewModel : NavGraphViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arugment = safeArgs.fragmentOneString
        viewModel.init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_destination_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.f_one_button)

        useArgs()
        setClickBehavior()
    }

    internal fun setClickBehavior(){
        lateinit var action : NavDirections

        button.setOnClickListener {
            viewModel.pointlessHandler.youClickedSomething()
            arugment?.let {
                action = viewModel.setAction(it, this.requireContext())
            }
            findNavController().navigate(action)
        }
    }

    internal fun useArgs(){
        textView = requireView().findViewById(R.id.frag_one_args)
        textView.text = arugment
    }

}