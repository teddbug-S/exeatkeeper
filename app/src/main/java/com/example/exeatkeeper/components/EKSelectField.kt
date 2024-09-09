package com.example.exeatkeeper.components

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.exeatkeeper.R
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun EKSelectField(
    @StringRes label: Int,
    items: List<String>,
    selectedItem: SharedTextState,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors()
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        EKOutlineTextField(
            value = selectedItem,
            onValueChange = { selectedItem.text = it },
            colors = colors,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { expanded = !expanded })
                },
            placeholder = label,
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(imageVector = icon, contentDescription = null, tint = colors.cursorColor)
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .padding(horizontal = 6.dp)
                .shadow(4.dp)
                .border(
                    0.dp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = MaterialTheme.shapes.large
                ),
            scrollState = rememberScrollState()
        ) {

            items.forEach { label ->
                DropdownMenuItem(text = {
                    Text(label)
                }, onClick = {
                    selectedItem.text = label
                    expanded = false
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSelectField() {

    val selectedItem = SharedTextState("")

    ExeatKeeperTheme {
        EKSelectField(
            label = R.string.select_school,
            items = listOf("Mawuli School", "Achimota School", "Kumasi SHS"),
            selectedItem = selectedItem
        )
    }
}
