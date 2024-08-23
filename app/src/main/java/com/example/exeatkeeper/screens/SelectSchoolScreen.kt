package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.EKFilledButton
import com.example.exeatkeeper.components.EKSelectField
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun SelectSchoolScreen() {

    val schoolList = listOf("Mawuli School", "Achimota School", "Presec Legon")
    val houseList = listOf(
        "Aggrey House",
        "Lincoln House",
    )
    val selectedSchool = SharedTextState("")
    val selectedHouse = SharedTextState("")


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(-(4).dp),
            modifier = Modifier.padding(36.dp)
        ) {
            Text(
                stringResource(R.string.select_school),
                fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                fontSize = 52.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Text(
                stringResource(R.string.sign_up_description),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 46.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Image(
                painter = painterResource(R.drawable.high_school_rafiki),
                contentDescription = null
            )
        }

        Surface(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier.padding(36.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        stringResource(R.string.select_school),
                        style = MaterialTheme.typography.labelLarge
                    )
                    EKSelectField(
                        label = R.string.none_selected,
                        items = schoolList,
                        selectedItem = selectedSchool
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        stringResource(R.string.select_house),
                        style = MaterialTheme.typography.labelLarge
                    )
                    EKSelectField(
                        label = R.string.none_selected,
                        items = houseList,
                        selectedItem = selectedHouse,

                        )
                }

                EKFilledButton(
                    label = R.string.continue_text,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = MaterialTheme.colorScheme.inverseSurface,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.offset(y = 16.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewSelectSchoolScreen() {
    ExeatKeeperTheme {
        SelectSchoolScreen()
    }
}