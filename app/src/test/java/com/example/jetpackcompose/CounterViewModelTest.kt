package com.example.jetpackcompose

import org.junit.Test
import org.junit.Assert.*

class CounterViewModelTest {

    private val viewModel = CounterViewModel()

    @Test
    fun testIncrement() {
        viewModel.increment()
        assertEquals(1, viewModel.count.value)
    }

    @Test
    fun testReset() {
        viewModel.increment()
        viewModel.reset()
        assertEquals(0, viewModel.count.value)
    }
}
