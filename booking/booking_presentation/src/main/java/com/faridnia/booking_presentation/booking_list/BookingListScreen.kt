package com.faridnia.booking_presentation.booking_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.faridnia.core.R
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.component.BookingDetailsItem
import com.faridnia.metime.core.data.model.SuccessfulBookingData
import com.faridnia.booking_presentation.successful_booking.SuccessfulBookingState
import com.faridnia.metime.core.data.model.getSampleSuccessfulBookingData

@LightAndDarkPreview
@Composable
fun PreviewBookingListScreen() {

    BookingListScreen(
        state = remember {
            mutableStateOf(
                SuccessfulBookingState(
                    successfulBookingData = getSampleSuccessfulBookingData()
                )
            )
        },
        navController = rememberNavController()
    )
}

@Composable
fun BookingListScreen(
    state: State<SuccessfulBookingState>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(
                start = 24.dp, end = 24.dp
            ),
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Your Bookings",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.72.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface
            )
        )

        Spacer(modifier = Modifier.height(34.dp))

        Tabs(
            bookingList = state.value.successfulBookingData,
            modifier = Modifier.Companion.weight(1f)
        )
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun Tabs(
    modifier: Modifier,
    bookingList: List<SuccessfulBookingData>
) {

    val tabItems = listOf("Past", "Upcoming")

    Column(
        modifier = modifier
    ) {
        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }

        val pagerState = rememberPagerState {
            tabItems.size
        }

        LaunchedEffect(selectedTabIndex) {
            pagerState.animateScrollToPage(selectedTabIndex)
        }

        LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
            if (pagerState.isScrollInProgress.not()) {
                selectedTabIndex = pagerState.currentPage
            }
        }

        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, tabTitle ->
                Tab(
                    modifier = Modifier
                        .height(48.dp),
                    selected = isTabSelected(index, selectedTabIndex),
                    onClick = { selectedTabIndex = index }) {
                    Text(
                        text = tabTitle,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.raleway_light)),
                            fontWeight = FontWeight(600),
                            color = getSelectedTabColor(selectedTabIndex, index),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn {
                items(items = bookingList, key = { it.id }) { successfulBookingData ->
                    BookingDetailsItem(successfulBookingData)
                }
            }
        }
    }
}

@Composable
private fun getSelectedTabColor(
    selectedTabIndex: Int,
    index: Int
) = if (isTabSelected(selectedTabIndex, index)) {
    MaterialTheme.colorScheme.primary
} else {
    MaterialTheme.colorScheme.onSurface
}

@Composable
private fun isTabSelected(index: Int, selectedTabIndex: Int) = index == selectedTabIndex