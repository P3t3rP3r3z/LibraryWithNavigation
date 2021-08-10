package com.p3t3rp3r3z.navlib

import android.util.Log

val TAG = "PointlessController Tag"
object PointlessController {
    private lateinit var handler: PointlessHandler

    fun setHandler(handler: PointlessHandler){
        this.handler = handler
    }

    fun handlerIsInitiallized() : Boolean{
        return ::handler.isInitialized
    }

    fun getHandler():PointlessHandler {
        return this.handler
    }
}