package com.example.jetpackcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import org.junit.Rule
import org.junit.Test

class CounterUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCounterButton() {
        composeTestRule.setContent {
            JetpackComposeTheme {
                Counter()
            }
        }
        
        // Cek teks awal
        composeTestRule
            .onNodeWithTag("counterText")
            .assertExists()
            .assertTextEquals("Count: 0")
            .assertIsDisplayed()

        // Klik tombol Tambah
        composeTestRule
            .onNodeWithText("Tambah")
            .performClick()

        // Cek apakah berubah
        composeTestRule
            .onNodeWithTag("counterText")
            .assertExists()
            .assertTextEquals("Count: 1")
            .assertIsDisplayed()
    }

    @Test
    fun testButtonReset() {
        composeTestRule.setContent {
            JetpackComposeTheme {
                Counter()
            }
        }

        // Klik Tambah dulu supaya angka jadi 1
        composeTestRule
            .onNodeWithText("Tambah")
            .performClick()

        // Klik Reset
        composeTestRule
            .onNodeWithText("Reset")
            .performClick()

        // Pastikan kembali ke 0
        composeTestRule
            .onNodeWithTag("counterText")
            .assertTextEquals("Count: 0")
            .assertIsDisplayed()
    }

    @Test
    fun testButtonTambah() {
        composeTestRule.setContent {
            JetpackComposeTheme {
                Counter()
            }
        }

        composeTestRule
            .onNodeWithText("Tambah")
            .performClick()

        composeTestRule
            .onNodeWithText("Count: 1")
            .assertIsDisplayed()
    }
}
