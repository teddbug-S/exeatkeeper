package com.example.exeatkeeper.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun RecentExeatWidget(firstName: String, lastName: String, date: String, location: String) {
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = MaterialTheme.shapes.extraLarge,
        modifier = Modifier.size(190.dp, 130.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(-2.dp)
            ) {
                Text(
                    firstName,
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    lastName,
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Text(
                "Signed on $date",
                fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )

            FilterChip(
                shape = MaterialTheme.shapes.extraLarge,
                selected = true,
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = location,
                        fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                }
            )
        }
    }
}


@Preview
@Composable
fun PreviewRecentExeatWidget() {
    ExeatKeeperTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RecentExeatWidget("Divine","Darkey", "31/07/2024", "Tema, Accra")
        }
    }
}
