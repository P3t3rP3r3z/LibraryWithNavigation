package com.p3t3rp3r3z.navlib.viewmodels

import android.content.Context
import com.p3t3rp3r3z.navlib.PointlessController
import com.p3t3rp3r3z.navlib.PointlessHandler
import com.p3t3rp3r3z.navlib.ui.DestinationFragmentOneDirections
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class NavGraphViewModelTest {
    private lateinit var viewModel : NavGraphViewModel
    private lateinit var pointlessController : PointlessController
    private lateinit var context : Context

    @Before
    fun setUp() {
        viewModel = NavGraphViewModel()
        context = mockk<Context>(relaxed = true)
    }

    @Test
    fun getPointlessHandler() {
        val testHandler = mockk<PointlessHandler>(relaxed = true)
        pointlessController = mockk<PointlessController>()
        every { pointlessController.getHandler() } returns  testHandler
        viewModel.init()
        val test = viewModel.pointlessHandler
        assert(test == testHandler)
    }

    @Test
    fun setAction() {
        every { context.getString(any()) } returns "Don't forget to bring a towel!"
        val test = viewModel.setAction("nice", context)
        val comparison = DestinationFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentTwo()
        assert(test == comparison)
        val test1 = viewModel.setAction("", context)
        assert(test1 != comparison)
        val newComparison = DestinationFragmentOneDirections.actionDestinationFragmentOneToDestinationFragmentThree( "Don't forget to bring a towel!" )
        assert(test1 == newComparison)

    }

    @After
    fun tearDown(){
        unmockkAll()
    }
}