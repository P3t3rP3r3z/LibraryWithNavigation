package com.p3t3rp3r3z.librarywithnavigation.ui.main

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.p3t3rp3r3z.librarywithnavigation.R
import com.p3t3rp3r3z.navlib.PointlessController
import com.p3t3rp3r3z.navlib.PointlessHandler
import com.p3t3rp3r3z.navlib.ui.NavHostActivity
val TAG = "Handler from App"
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        PointlessController.setHandler(
            object : PointlessHandler{
                override fun youClickedSomething() {
                    Log.d(TAG, "you clicked the thing")
                }

                override fun youGotValueA() {
                    Log.d(TAG, "you did the first thing")
                }

                override fun youGotValueB() {
                    Log.d(TAG, "you did the second thing")
                }

            }
        )

        val button = view?.findViewById<Button>(R.id.main_fragment_button)
        button?.setOnClickListener {
            val intent = Intent(this.context, NavHostActivity::class.java)
            startActivity(intent)

        }
    }

}