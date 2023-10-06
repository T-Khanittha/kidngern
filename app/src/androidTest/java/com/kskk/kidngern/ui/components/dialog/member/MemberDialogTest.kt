package com.kskk.kidngern.ui.components.dialog.member

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.kskk.kidngern.ui.theme.KidngernTheme
import org.junit.Rule
import org.junit.Test

class MemberDialogTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun addMemberDialogTest() {
        composeTestRule.setContent {
            KidngernTheme {
                MemberDialog(
                    dialogState = MemberDialogUiState.AddMember,
                    onClickAction = {},
                    onDismiss = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Add new member").assertExists()
        composeTestRule.onNodeWithText("Member name").assertExists()
        composeTestRule.onNodeWithText("Add").assertExists()
    }

    @Test
    fun updateMemberDialogTest() {
        composeTestRule.setContent {
            KidngernTheme {
                MemberDialog(
                    dialogState = MemberDialogUiState.UpdateMember,
                    onClickAction = {},
                    onDismiss = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Update member name").assertExists()
        composeTestRule.onNodeWithText("Member name").assertExists()
        composeTestRule.onNodeWithText("Update").assertExists()
    }
}