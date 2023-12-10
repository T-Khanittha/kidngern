package com.kskk.kidngern.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kskk.kidngern.constant.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val tabTitle = listOf("Menu", "Payer")
    val icons = listOf(Icons.Default.Menu, Icons.Default.Person)
    var tabIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = modifier,
        topBar = {
            TabRow(selectedTabIndex = tabIndex) {
                tabTitle.forEachIndexed { index, tabTitle ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Row(
                                modifier,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(imageVector = icons[index], contentDescription = tabTitle)
                                Text(tabTitle, textAlign = TextAlign.Center)
                            }
                        }
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
            if (tabIndex == 0) {
                MenuScreen(uiState = UiState.Menu.Empty)
            } else{
                PayerScreen(uiState = UiState.Payer.Empty)
            }
        }
    )
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}
