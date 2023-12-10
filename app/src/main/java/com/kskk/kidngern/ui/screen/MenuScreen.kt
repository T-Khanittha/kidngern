package com.kskk.kidngern.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kskk.kidngern.constant.UiState
import com.kskk.kidngern.ui.components.emptyItem.EmptyItem

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    uiState: UiState
) {
    val verticalArrangement =
        if (uiState == UiState.Menu.Empty) Arrangement.Center else Arrangement.Top
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmptyItem(title = "Have no any menu", subTitle = "please add new menu")
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen(uiState = UiState.Menu.Empty)
}