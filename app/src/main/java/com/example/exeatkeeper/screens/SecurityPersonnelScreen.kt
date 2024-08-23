package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.exeatkeeper.components.EKOutlineTextField
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun SecurityPersonnelScreen() {

    val guardOneName = SharedTextState("")
    val guardTwoName = SharedTextState("")

    val guardOneNumber = SharedTextState("")
    val guardTwoNumber = SharedTextState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Surface(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(bottomStart = 36.dp, bottomEnd = 36.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 8.dp, bottom = 36.dp, start = 36.dp, end = 36.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(-(10).dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.security_post),
                        contentDescription = null,
                        modifier = Modifier.size(198.dp)
                    )
                    Text(
                        text = stringResource(R.string.security),
                        fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                        fontSize = 52.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                    Text(
                        stringResource(R.string.security_description),
                        fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(horizontal = 52.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 8.dp)
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            stringResource(R.string.security_guard_1),
                            style = MaterialTheme.typography.labelLarge
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            EKOutlineTextField(
                                value = guardOneName,
                                placeholder = R.string.full_name
                            )
                            EKOutlineTextField(
                                value = guardOneNumber,
                                placeholder = R.string.phone_number
                            )
                        }
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            stringResource(R.string.security_guard_2),
                            style = MaterialTheme.typography.labelLarge
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            EKOutlineTextField(
                                value = guardTwoName,
                                placeholder = R.string.full_name
                            )
                            EKOutlineTextField(
                                value = guardTwoNumber,
                                placeholder = R.string.phone_number
                            )
                        }
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 36.dp, end = 36.dp, bottom = 28.dp)
//                .weight(1f)
        ) {
            Text(
                "You can add more security guards later in settings",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 20.dp).width(242.dp),
                lineHeight = 16.sp
            )

            EKFilledButton(
                label = R.string.continue_text,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}


@Preview
@Composable
fun PreviewSecurityPersonnelScreen() {
    ExeatKeeperTheme {
        SecurityPersonnelScreen()
    }
}