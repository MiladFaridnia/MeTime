package com.faridnia.metime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.metime.R
import com.faridnia.metime.presentation.ui.choose_service_type.ServiceType
import com.faridnia.metime.util.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewServiceType() {
    MaterialTheme {
        ServiceTypeItem(
            ServiceType(photoResourceId = R.drawable.gel_pedicure, title = "Pedicure", price = 15)
        )
    }
}

@Composable
fun ServiceTypeItem(serviceType: ServiceType) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .width(72.dp)
                .height(72.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = serviceType.photoResourceId),
            contentDescription = serviceType.title,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = serviceType.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Text(
                text = "${serviceType.price} $",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            )
        }

        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            painter = painterResource(id = R.drawable.arrow_right),
            contentDescription = "Arrow ",
            contentScale = ContentScale.None,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
    }
}