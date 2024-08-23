package com.example.exeatkeeper.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exeatkeeper.components.SecurityContactCard
import com.example.exeatkeeper.lib.getOrdinal


@Composable
fun SecurityInformationScreen(navController: NavController) {

    var securityPersonnelInfo by remember {
        mutableStateOf(
            listOf(
                mapOf(
                    "name" to "Daniel Sampson",
                    "phoneNumber" to "0551651940",
                ),
                mapOf(
                    "name" to "John Doe",
                    "phoneNumber" to "0551651941",
                ),
                mapOf(
                    "name" to "Jane Smith",
                    "phoneNumber" to "0551651942",
                ),
            )
        )
    }


    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Arrow back"
                )
            }

            Text(text = "Security information", style = MaterialTheme.typography.labelLarge)
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(-12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            securityPersonnelInfo.forEachIndexed { index, map ->
                SecurityContactCard(
                    title = "${getOrdinal(index + 1)} security",
                    name = map["name"]!!,
                    phoneNumber = map["phoneNumber"]!!,
                    onDeleteClicked = {
                        securityPersonnelInfo =
                            securityPersonnelInfo.toMutableList().apply { removeAt(index) }
                    },
                )
            }
        }
    }
}
