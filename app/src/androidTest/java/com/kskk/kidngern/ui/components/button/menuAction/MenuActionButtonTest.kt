package com.kskk.kidngern.ui.components.button.menuAction

import com.kskk.kidngern.ui.components.button.MenuActionButton
import com.kskk.kidngern.ui.components.button.MenuButtonType
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.kskk.kidngern.ui.theme.KidngernTheme
import org.junit.Rule
import org.junit.Test

class MenuActionButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun addMenuActionButtonTest() {
        composeTestRule.setContent {
            KidngernTheme {
                MenuActionButton(onClickButton = {}, type = MenuButtonType.ADD)
            }
        }

        composeTestRule.onNodeWithText("Add Menu").assertExists()
        composeTestRule.onNodeWithContentDescription("Add Icon").assertExists()
    }

    @Test
    fun editMenuActionButtonTest() {
        composeTestRule.setContent {
            KidngernTheme {
                MenuActionButton(onClickButton = {}, type = MenuButtonType.EDIT)
            }
        }

        composeTestRule.onNodeWithText("Edit Menu").assertExists()
        composeTestRule.onNodeWithContentDescription("Edit Icon").assertExists()

    }
}