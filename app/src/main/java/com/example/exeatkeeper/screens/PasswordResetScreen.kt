package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.EKFilledButton
import com.example.exeatkeeper.components.EKOutlineTextField
import com.example.exeatkeeper.lib.SharedTextState


@Composable
fun PasswordResetScreen(navController: NavController) {

    val oldPassword = SharedTextState("")
    val newPassword = SharedTextState("")
    val confirmNewPassword = SharedTextState("")

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
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

            Text(text = "Change password", style = MaterialTheme.typography.labelLarge)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(44.dp),
                modifier = Modifier.offset(y = 22.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.security_guard),
                    contentDescription = "Security guard illustration"
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(22.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("Old Password", style = MaterialTheme.typography.labelLarge)
                        EKOutlineTextField(
                            value = oldPassword,
                            placeholder = R.string.password,
                            colors = OutlinedTextFieldDefaults.colors(
                                cursorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("New Password", style = MaterialTheme.typography.labelLarge)
                        EKOutlineTextField(value = newPassword, placeholder = R.string.password)
                        Spacer(modifier = Modifier.height(4.dp))
                        EKOutlineTextField(
                            value = confirmNewPassword,
                            placeholder = R.string.confirm_password
                        )
                    }
                }
            }

            EKFilledButton(label = R.string.change_password)
        }

    }
}