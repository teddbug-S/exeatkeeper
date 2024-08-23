package com.example.exeatkeeper.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.exeatkeeper.R
import com.example.exeatkeeper.getTheme
import com.example.exeatkeeper.setTheme
import kotlinx.coroutines.launch

@Composable
fun SelectThemeDialog(onDismiss: () -> Unit = {}) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current.applicationContext
    val currentTheme by getTheme(context).collectAsState(initial = null)

    val themeOptions = listOf("System Default", "Light", "Dark")

    // Only initialize selectedOption when currentTheme is not null
    val selectedOption = remember(currentTheme) {
        if (currentTheme != null) mutableStateOf(themeOptions[currentTheme!!])
        else null
    }

    // Only show the dialog when the currentTheme has been determined
    if (selectedOption != null) {
        Dialog(onDismissRequest = { onDismiss() }) {

            Surface(
                modifier = Modifier
                    .height(260.dp),
                shape = RoundedCornerShape(18.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier
                        .padding(24.dp)
                        .padding(bottom = 0.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Change Theme",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.align(Alignment.Start),
                        fontSize = 18.sp
                    )

                    Column(
                        modifier = Modifier
                            .selectableGroup()
                    ) {
                        themeOptions.forEach { text ->

                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .selectable(
                                        selected = (text == selectedOption.value),
                                        onClick = { selectedOption.value = text },
                                        role = Role.RadioButton
                                    )
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = (text == selectedOption.value),
                                    onClick = null
                                )
                                Text(
                                    text = text,
                                    style = MaterialTheme.typography.labelMedium,
                                    modifier = Modifier.padding(start = 16.dp),
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        TextButton(onClick = { onDismiss() }) {
                            Text(
                                stringResource(R.string.cancel),
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.error,
                                fontSize = 16.sp
                            )
                        }

                        TextButton(onClick = {
                            scope.launch {
                                val index = themeOptions.indexOf(selectedOption.value)
                                if (currentTheme != index) {
                                    setTheme(context, index)
                                }
                            }
                            onDismiss()
                        }) {
                            Text(
                                stringResource(R.string.confirm),
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
