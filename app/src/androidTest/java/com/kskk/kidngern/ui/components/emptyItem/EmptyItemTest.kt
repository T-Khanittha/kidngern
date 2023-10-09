package com.kskk.kidngern.ui.components.emptyItem

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.kskk.kidngern.R
import com.kskk.kidngern.ui.theme.KidngernTheme
import org.junit.Rule
import org.junit.Test

class EmptyItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun imageShouldCatInBox() {
        composeTestRule.setContent {
            KidngernTheme {
                EmptyItem(
                    title = "titleTest",
                    subTitle = "subTitleTest"
                )
            }
        }
        composeTestRule.onNodeWithTag(R.drawable.ic_cat_in_box.toString()).assertIsDisplayed()
    }

    @Test
    fun titleAndSubtitleShouldSameParameter() {
        val expectTitle = "titleTest"
        val expectSubtitle = "subTitleTest"
        composeTestRule.setContent {
            KidngernTheme {
                EmptyItem(
                    title = "titleTest",
                    subTitle = "subTitleTest"
                )
            }
        }
        composeTestRule.onNodeWithText(expectTitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(expectSubtitle).assertIsDisplayed()
    }
}