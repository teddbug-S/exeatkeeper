package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.EKSearchBar
import com.example.exeatkeeper.components.StudentProfileCard
import com.example.exeatkeeper.lib.SharedTextState


@Composable
fun StudentsScreen(navController: NavController, innerPadding: PaddingValues) {

    val studentsData by rememberSaveable {
        mutableStateOf(
            listOf<Map<String, String>>(
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),
                mapOf(
                    "name" to "Gabriel Boye",
                    "grade" to "2 Science 4",
                    "exeatCount" to "2",
                    "chancesLeft" to "1"
                ),

                )
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
            if (studentsData.isEmpty()) {

                item {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillParentMaxHeight()
                    ) {
                        Text(
                            text = "Click on the + button to add students!",
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 26.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                                .padding(bottom = 36.dp)
                                .width(260.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = 32.sp
                        )
                        Image(
                            painter = painterResource(id = R.drawable.no_history),
                            contentDescription = "No data available",
                        )
                        Text(
                            "No data available",
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

                items(studentsData.size) { index ->
                    StudentProfileCard(
                        name = studentsData[index]["name"].toString(),
                        grade = studentsData[index]["grade"].toString(),
                        exeatCount = studentsData[index]["exeatCount"].toString(),
                        chancesLeft = studentsData[index]["chancesLeft"].toString()
                    )
                }
            }
        }
    }
}
