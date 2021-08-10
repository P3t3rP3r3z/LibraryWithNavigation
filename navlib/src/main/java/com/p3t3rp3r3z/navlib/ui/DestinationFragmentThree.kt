package com.p3t3rp3r3z.navlib.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.p3t3rp3r3z.navlib.R
import com.p3t3rp3r3z.navlib.viewmodels.NavGraphViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DestinationFragmentThree.newInstance] factory method to
 * create an instance of this fragment.
 */
class DestinationFragmentThree : Fragment() {
    val viewModel : NavGraphViewModel by navGraphViewModels(R.id.nav_graph)
    private var param1: String? = null
    private lateinit var textView : TextView
    private lateinit var impressedButton: Button
    private lateinit var unImpressedButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.third_fragment_tv)
        impressedButton = view.findViewById(R.id.impressed)
        unImpressedButton = view.findViewById(R.id.not_impressed)

        val safeArgs : DestinationFragmentThreeArgs by navArgs()
        safeArgs.fragmentThreeString.let {
            param1 = it
            textView.text = it
        }

        viewModel.init()
        setClicks()
    }

    private fun setClicks(){
        impressedButton.setOnClickListener {
            viewModel.pointlessHandler.youGotValueA()
            val action = DestinationFragmentThreeDirections.actionDestinationFragmentThreeToDestinationFragmentThreeSub1()
            findNavController().navigate(action)
        }
        unImpressedButton.setOnClickListener {
            viewModel.pointlessHandler.youGotValueB()
            val action = DestinationFragmentThreeDirections.actionDestinationFragmentThreeToDestinationFragmentThreeSub2()
            findNavController().navigate(action)
        }
    }

}