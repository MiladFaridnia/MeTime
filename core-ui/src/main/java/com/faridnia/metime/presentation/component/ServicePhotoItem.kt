package com.faridnia.metime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.core.R
import com.faridnia.metime.core.data.model.Service
import com.faridnia.metime.core.data.model.getSampleServices
import com.faridnia.metime.presentation.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewPhotoItem() {
    MaterialTheme {
        PhotoItem(
            service = getSampleServices().first(),
            onClick = {}
        )
    }
}

@Composable
fun PhotoItem(
    service: Service,
    onClick: (service: Service) -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onClick.invoke(service)
        },
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .width(125.dp)
                .height(125.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = service.photoResourceId),
            contentDescription = service.title,
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = service.title,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                letterSpacing = 0.14.sp,
            )
        )

        Spacer(modifier = Modifier.height(26.dp))

    }
}