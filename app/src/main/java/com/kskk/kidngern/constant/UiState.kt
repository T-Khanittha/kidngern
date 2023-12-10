package com.kskk.kidngern.constant

sealed class UiState {

    object Menu : UiState() {
        object Empty : UiState()
        data class HasItem(val list: List<String>) : UiState()
    }

    object Payer : UiState() {
        object Empty : UiState()
        data class HasItem(val list: List<String>) : UiState()
    }
}