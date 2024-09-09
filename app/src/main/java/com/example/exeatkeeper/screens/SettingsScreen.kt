package com.example.exeatkeeper.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.exeatkeeper.components.SelectThemeDialog
import com.example.exeatkeeper.components.SettingsGroup
import com.example.exeatkeeper.components.SettingsMenuItem
import com.example.exeatkeeper.getTheme
import com.example.exeatkeeper.navigation.PasswordResetScreenClass
import com.example.exeatkeeper.navigation.SecurityPersonnelInformationScreenClass


@Composable
fun SettingsScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {

    val context = LocalContext.current.applicationContext
    val currentThemeState by getTheme(context).collectAsState(initial = null)

    val themeName =
        when (currentThemeState) {
            1 -> "Light"
            2 -> "Dark"
            else -> "System default"
        }

    if (currentThemeState != null) {
        val showDialog = remember { mutableStateOf(false) }

        if (showDialog.value) {
            SelectThemeDialog(onDismiss = { showDialog.value = false })
        }

        var uri: Uri? by remember {
            mutableStateOf(
                Uri.parse(
                    context.filesDir.resolve("profilePicture.jpg").toUri().toString()
                )
            )
        }

        val singleMediaPicker = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = {
                val input = it?.let { it1 -> context.contentResolver.openInputStream(it1) }
                val outputFile = context.filesDir.resolve("profilePicture.jpg")
                input?.copyTo(outputFile.outputStream())
                uri = outputFile.toUri()
            })


        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(vertical = 20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {

                AsyncImage(
                    model = uri,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .size(82.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        .clickable {
                            singleMediaPicker.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        }

                )

                Spacer(modifier = Modifier.width(18.dp))
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        "Joseph Akpalu",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 24.sp
                    )
                    Text(
                        "House Father",
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 16.sp
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                SettingsGroup(label = "account") {
                    SettingsMenuItem(
                        title = "Change name",
                        label = "Joseph Akpalu",
                        painter = rememberVectorPainter(image = Icons.Default.AccountCircle)
                    )
                    SettingsMenuItem(
                        title = "Update profile picture",
                        label = "Joseph Akpalu",
                        painter = rememberVectorPainter(image = Icons.Default.Image),
                        onClick = {
                            singleMediaPicker.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        }
                    )
                    SettingsMenuItem(
                        title = "Change password",
                        label = "********",
                        painter = rememberVectorPainter(image = Icons.Default.Password),
                        onClick = { navController.navigate(PasswordResetScreenClass) }
                    )
                }

                SettingsGroup(label = "security") {
                    SettingsMenuItem(
                        title = "Update security information",
                        label = "3 security guards configured",
                        painter = rememberVectorPainter(image = Icons.Default.Shield),
                        onClick = { navController.navigate(SecurityPersonnelInformationScreenClass) }
                    )
                }

                SettingsGroup(label = "theme") {
                    SettingsMenuItem(
                        title = "Change theme",
                        label = themeName,
                        painter = rememberVectorPainter(image = Icons.Default.LightMode),
                        onClick = { showDialog.value = true }
                    )
                }

                SettingsGroup(label = "data") {
                    SettingsMenuItem(
                        title = "Clear students data",
                        label = "300 students • 132 KB",
                        painter = rememberVectorPainter(image = Icons.Default.Delete),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error),
                        onClick = { }
                    )
                }
            }

        }
    }
}