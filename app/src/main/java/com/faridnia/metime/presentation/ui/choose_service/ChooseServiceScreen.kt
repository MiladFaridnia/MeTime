package com.faridnia.metime.presentation.ui.choose_service

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.faridnia.metime.R
import com.faridnia.metime.presentation.component.PhotoItem
import com.faridnia.metime.presentation.component.SecondaryButton
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme
import com.faridnia.metime.util.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewChooseServiceScreen() {
    MeTimeTheme {
        ChooseServiceScreen(
            state = remember { mutableStateOf(ChooseServiceState()) },
            onEvent = {},
            navController = rememberNavController()
        )
    }
}

@Composable
fun ChooseServiceScreen(
    state: State<ChooseServiceState>,
    onEvent: (ChooseServiceEvent) -> Unit,
    navController: NavController
) {

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(start = 24.dp, end = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "MeTime", style = TextStyle(
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(50.dp))

        PageState()

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Please, choose a service:", style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.72.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(70.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            items(getPhotoItems()) {
                PhotoItem(it)
            }
        }

        Spacer(modifier = Modifier.weight(1.0f))

        SecondaryButton(
            modifier = Modifier.weight(1.0f),
            buttonText = "Skip",
            isEnabled = true,
            isLoading = false
        ) {
        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}


fun getPhotoItems() = listOf(
    ServiceItem(R.drawable.nail, "Nail"),
    ServiceItem(R.drawable.eyebrowns, "Eyebrowns"),
    ServiceItem(R.drawable.massage, "Massage"),
    ServiceItem(R.drawable.hair, "Hair"),
)

@Composable
private fun PageState() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {

        Box(
            modifier = Modifier
                .width(50.dp)
                .height(10.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(size = 20.dp)
                )
        )

        Image(
            painter = painterResource(id = R.drawable.dot),
            contentDescription = "dot",
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )

        Image(
            painter = painterResource(id = R.drawable.dot),
            contentDescription = "dot",
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )

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