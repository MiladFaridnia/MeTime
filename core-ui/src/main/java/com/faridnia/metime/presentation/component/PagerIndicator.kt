package com.faridnia.metime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.faridnia.core.R
import com.faridnia.metime.presentation.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewChooseServiceScreen() {
        PagerIndicator(
            selectedPageIndex = 2
        )
}

@Composable
fun PagerIndicator(selectedPageIndex: Int, totalPages: Int = 4) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {

        for (i in 1..totalPages) {
            if (selectedPageIndex == i) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(10.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = "dot",
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }
        }
    }
}
