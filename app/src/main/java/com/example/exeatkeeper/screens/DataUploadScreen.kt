package com.example.exeatkeeper.screens

import android.content.Context
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.exeatkeeper.components.EKRoundedCheckBox
import com.example.exeatkeeper.components.FileUploadWidget
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun DataUploadScreen() {

    val addStudentsManuallyChecked = remember {
        mutableStateOf(false)
    }

    val buttonLabel =
        if (addStudentsManuallyChecked.value) R.string.continue_text else R.string.upload

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.offset(y = 32.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(R.drawable.data_upload), contentDescription = null)
                Text(
                    text = stringResource(R.string.upload_student_data),
                    fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                )

                Text(
                    "Upload csv file containing data of students in your house.",
                    fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(horizontal = 32.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                FileUploadWidget()
                EKRoundedCheckBox(
                    label = "Add students manually",
                    checked = addStudentsManuallyChecked.value,
                    onValueChange = { value -> addStudentsManuallyChecked.value = value }
                )
            }
        }

        EKFilledButton(
            label = buttonLabel,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
        )
    }
}


@Preview
@Composable
fun PreviewDataUploadScreen() {
    ExeatKeeperTheme {
        DataUploadScreen()
    }
}