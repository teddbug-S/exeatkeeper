package com.example.exeatkeeper.screens

import ExeatItemWidget
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.EKSearchBar
import com.example.exeatkeeper.components.LocationFilterWidget
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.navigation.SettingsScreenClass


@Composable
fun HistoryScreen(navController: NavController, innerPadding: PaddingValues) {

    val exeatItems by rememberSaveable {
        mutableStateOf(
            listOf<Map<String, String>>()
        )
    }

    val locations by rememberSaveable {
        mutableStateOf(
            listOf<Map<String, String>>()
        )
    }
    val searchQuery = SharedTextState("")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 20.dp)
    ) {

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(top = 10.dp, bottom = 88.dp)
        ) {
            if (exeatItems.isEmpty()) {

                item {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillParentMaxHeight()
                    ) {
                        Text(
                            text = "See all signed exeats here.",
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 26.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                                .padding(bottom = 36.dp)
                                .width(180.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = 32.sp
                        )
                        Image(
                            painter = painterResource(id = R.drawable.no_history),
                            contentDescription = "No recent data",
                        )
                        Text(
                            "No history available",
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {

                item {
                    EKSearchBar(value = searchQuery)
                }

                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(locations.size) { index ->

                                val location = locations.get(index)
                                val label = location["location"].toString()
                                val selected = location["selected"] as Boolean

                                LocationFilterWidget(selected = selected, label = label)
                            }
                        }
                    }
                }

                items(exeatItems.size) { index ->
                    ExeatItemWidget(
                        name = exeatItems.get(index)["name"].toString(),
                        description = exeatItems.get(index)["description"].toString(),
                        date = exeatItems[index]["date"].toString(),
                        location = exeatItems.get(index)["location"].toString()
                    )
                }
            }
        }
    }
}
