package com.kskk.kidngern.ui.components.button

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kskk.kidngern.R
import com.kskk.kidngern.ui.theme.KidngernTheme

@Composable
fun MenuActionButton(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit,
    type: MenuButtonType,
) {
    val icon = when (type) {
        MenuButtonType.ADD -> Icons.Filled.Add
        MenuButtonType.EDIT -> Icons.Filled.Edit
    }

    val contentDescription = when (type) {
        MenuButtonType.ADD -> "Add Icon"
        MenuButtonType.EDIT -> "Edit Icon"
    }

    val buttonText = when (type) {
        MenuButtonType.ADD -> stringResource(id = R.string.add_menu)
        MenuButtonType.EDIT -> stringResource(id = R.string.edit_menu)
    }

    OutlinedButton(
        modifier = modifier,
        onClick = { onClickButton() }
    ) {
        Icon(imageVector = icon, contentDescription = contentDescription,modifier= Modifier.size(24.dp))
        Spacer(modifier = Modifier.padding(2.dp))
        Text(text = buttonText, style = MaterialTheme.typography.bodyLarge)
    }
}

enum class MenuButtonType {
    ADD, EDIT
}

@Preview(showBackground = true)
@Composable
fun AddMenuButtonPreview() {
    KidngernTheme {
        MenuActionButton(onClickButton = {}, type = MenuButtonType.ADD)
    }
}

@Preview(showBackground = true)
@Composable
fun EditMenuButtonPreview() {
    KidngernTheme {
        MenuActionButton(onClickButton = {}, type = MenuButtonType.EDIT)
    }
}