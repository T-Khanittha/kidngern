package com.kskk.kidngern.ui.components.dialog.member

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kskk.kidngern.R
import com.kskk.kidngern.ui.components.dialog.model.DialogDetail
import com.kskk.kidngern.ui.theme.KidngernTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberDialog(
    modifier: Modifier = Modifier,
    dialogState: MemberDialogUiState,
    dialogValue: String = "",
    onClickAction: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    var txtField by remember { mutableStateOf(dialogValue) }
    val dialogDetail by remember { mutableStateOf(getDialogDetail(dialogState)) }

    Dialog(onDismissRequest = { onDismiss() }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = dialogDetail.title,
                            style = MaterialTheme.typography.headlineSmall,
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(vertical = 16.dp),
                            textStyle = MaterialTheme.typography.bodyLarge,
                            placeholder = { Text(text = dialogDetail.placeholder) },
                            label = { Text(text = dialogDetail.placeholder) },
                            value = txtField,
                            onValueChange = { txtField = it }
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { onDismiss() }) {
                            Text(text = stringResource(R.string.cancel))
                        }
                        Spacer(modifier = Modifier.padding(4.dp))
                        TextButton(onClick = { onClickAction(txtField) }) {
                            Text(text = dialogDetail.buttonActionText)
                        }
                    }
                }
            }
        }
    }
}

sealed interface MemberDialogUiState {
    object AddMember : MemberDialogUiState
    object UpdateMember : MemberDialogUiState
}

private fun getDialogDetail(dialogState: MemberDialogUiState): DialogDetail {
    return when (dialogState) {
        MemberDialogUiState.AddMember -> DialogDetailData.addMember
        MemberDialogUiState.UpdateMember -> DialogDetailData.updateMember
    }
}

object DialogDetailData {
    val addMember = DialogDetail(
        title = "Add new member",
        placeholder = "Member name",
        buttonActionText = "Add"
    )
    val updateMember = DialogDetail(
        title = "Update member name",
        placeholder = "Member name",
        buttonActionText = "Update"
    )
}

@Preview(showBackground = true)
@Composable
fun DialogMenuPreview() {
    KidngernTheme {
        MemberDialog(
            dialogState = MemberDialogUiState.AddMember,
            onClickAction = {},
            onDismiss = {})
    }
}
