package com.faridnia.metime.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.core.R
import com.faridnia.metime.presentation.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewSecondaryButton() {
        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Continue",
            isEnabled = true,
            isLoading = false,
            onClick = {
            }
        )
}

@Composable
fun SecondaryButton(
    modifier: Modifier,
    buttonText: String,
    isEnabled: Boolean,
    isLoading: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier
            .height(54.dp)
            .background(
                color =  MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(size = 10.dp)
            ),
            //.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
        colors = handleEnableButtonColors(isEnabled),
        enabled = true
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 2.5.dp
            )
        } else {
            Text(
                text = buttonText,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(600),
                    color = handleEnableTextColor(isEnabled),
                )
            )
        }
    }
}

@Composable
private fun handleEnableTextColor(isEnabled: Boolean) =
    if (isEnabled) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

@Composable
private fun handleEnableButtonColors(isEnabled: Boolean) =
    if (isEnabled) {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
        )
    } else {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }