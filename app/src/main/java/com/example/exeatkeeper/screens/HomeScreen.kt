package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.DashboardWidget
import com.example.exeatkeeper.components.RecentExeatWidget


@Composable
fun HomeScreen(navController: NavController, innerPadding: PaddingValues) {

    val recentItems = mutableListOf<Map<String, String>>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 20.dp, vertical = 12.dp)
            .background(MaterialTheme.colorScheme.surface),
    ) {

        DashboardWidget()

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Recent", style = MaterialTheme.typography.labelLarge, fontSize = 16.sp)

            if (recentItems.isEmpty()) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 54.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.no_recent_data),
                        contentDescription = "No recent data"
                    )
                    Text(
                        "No exeats signed yet!",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(recentItems.size) { index ->
                        RecentExeatWidget(
                            firstName = recentItems[index]["firstName"] ?: "",
                            lastName = recentItems[index]["lastName"] ?: "",
                            date = recentItems[index]["date"] ?: "",
                            location = recentItems[index]["location"] ?: ""
                        )
                    }
                }
            }
        }
    }
}