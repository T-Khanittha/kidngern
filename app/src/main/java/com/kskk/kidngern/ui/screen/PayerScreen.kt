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
fun PayerScreen(
    modifier: Modifier = Modifier,
    uiState: UiState
) {
    val verticalArrangement =
        if (uiState == UiState.Payer.Empty) Arrangement.Center else Arrangement.Top
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmptyItem(title = "Have no any payer in list", subTitle = "please add new payer")
    }
}

@Preview
@Composable
fun PayerScreenPreview() {
    MenuScreen(uiState = UiState.Payer.Empty)
}