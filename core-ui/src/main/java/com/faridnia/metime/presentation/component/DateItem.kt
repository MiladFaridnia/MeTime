package com.faridnia.metime.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.core.R
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.MeTimeTheme

@LightAndDarkPreview
@Composable
fun PreviewDateItem() {
    MeTimeTheme {
        DateItem(
            itemState = DateItemState.DeActive,
            dateString = "28 \nTue",
            onItemSelectedClick = {})
    }
}

@Composable
fun DateItem(
    itemState: DateItemState = DateItemState.Default,
    dateString: String,
    onItemSelectedClick: (String) -> Unit
) {
    val isSelected = remember {
        mutableStateOf(true)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(
                width = 0.5.dp,
                color = getBorderColor(itemState),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .width(63.dp)
            .padding(8.dp)
            .clickable {
                if (itemState != DateItemState.DeActive) {
                    onItemSelectedClick(dateString)
                    isSelected.value = isSelected.value.not()
                }
            }
    ) {
        Text(
            text = dateString, style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.18.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = getBorderColor(itemState),
                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
private fun getBorderColor(itemState: DateItemState) = when (itemState) {
    is DateItemState.Selected -> MaterialTheme.colorScheme.primary
    is DateItemState.DeActive -> MaterialTheme.colorScheme.inverseOnSurface
    is DateItemState.Default -> MaterialTheme.colorScheme.onSurface
}

sealed class DateItemState {
    data object Selected : DateItemState()
    data object DeActive : DateItemState()
    data object Default : DateItemState()
}