package com.p3t3rp3r3z.navlib.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.p3t3rp3r3z.navlib.PointlessController
import com.p3t3rp3r3z.navlib.PointlessHandler
import com.p3t3rp3r3z.navlib.R
import com.p3t3rp3r3z.navlib.ui.DestinationFragmentOneDirections

val TAG = "ViewModelTag"
val ARGONE = "now"
val ARGTWO = "nice"

class NavGraphViewModel: ViewModel() {
    lateinit var pointlessHandler : PointlessHandler

    fun init(){
        val pointlessController = PointlessController
        if (pointlessController.handlerIsInitiallized()) {
            this.pointlessHandler = pointlessController.getHandler()
        }
    }

    fun setAction(arg: String, context: Context) : NavDirections {
        val fragThreeArg = context.getString(R.string.towel)
        return if (arg.toLowerCase().contains(ARGONE) || arg.toLowerCase().contains(ARGTWO)) {
            DestinationFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentTwo()
        } else {
            DestinationFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentThree( fragThreeArg )
        }
    }
}