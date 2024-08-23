package com.example.exeatkeeper.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.exeatkeeper.lib.SharedTextState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.exeatkeeper.R
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.stringResource


@Composable
fun EKPasswordField(@StringRes placeholder: Int, value: SharedTextState) {

    var showPassword by remember { mutableStateOf(false) }

    EKOutlineTextField(
        value = value,
        placeholder = placeholder,
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation('*')
        },
        trailingIcon = {
            val iconImage =
                if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

            IconButton(
                onClick = { showPassword = !showPassword },
                modifier = Modifier.padding(end = 12.dp)
            ) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = stringResource(R.string.toggle_password_visibility)
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary
        )
    )

}


@Preview
@Composable
fun EKPasswordFieldPreview() {
    ExeatKeeperTheme {
        val passwordState = SharedTextState()
        EKPasswordField(placeholder = R.string.password, value = passwordState)
    }
}