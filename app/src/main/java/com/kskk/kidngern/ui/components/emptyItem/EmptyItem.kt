package com.kskk.kidngern.ui.components.emptyItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kskk.kidngern.R
import com.kskk.kidngern.ui.theme.KidngernTheme

@Composable
fun EmptyItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String
) {
    val iconResId = R.drawable.ic_cat_in_box
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(iconResId.toString()),
                painter = painterResource(iconResId),
                contentDescription = "Empty Item Icon"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = subTitle,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyItemPreview() {
    KidngernTheme {
        EmptyItem(
            title = "ไม่มีรายชื่อคนจ่ายที่เพิ่มไว้",
            subTitle = "กรุณากดปุ่มเพิ่มรายชื่อ \n" +
                    "เพื่อสร้างรายชื่อผู้ที่จะจ่ายรายการ"
        )
    }
}