package com.example.exeatkeeper.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.R
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EKOutlineTextField(
    value: SharedTextState,
    @StringRes placeholder: Int,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    enabled: Boolean = true,
    readOnly: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
) {

    val innerPadding = if (singleLine) {
        PaddingValues(horizontal = 22.dp)
    } else PaddingValues(20.dp)

    BasicTextField(
        value = value.text,
        onValueChange = if (onValueChange.equals({})) onValueChange else { it: String ->
            value.text = it
        },
        singleLine = true,
        textStyle = TextStyle(
            color = colors.cursorColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MaterialTheme.typography.labelLarge.fontFamily
        ),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .height(52.dp)
            .border(
                width = 2.dp,
                color = colors.cursorColor,
                shape = MaterialTheme.shapes.extraLarge
            ),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        readOnly = readOnly,
        enabled = enabled,
        cursorBrush = SolidColor(colors.cursorColor),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = value.text,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                placeholder = { Text(stringResource(placeholder)) },
                label = null,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                prefix = prefix,
                suffix = suffix,
                supportingText = supportingText,
                singleLine = singleLine,
                enabled = enabled,
                contentPadding = innerPadding,
                isError = isError,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                colors = colors,
                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled = enabled,
                        isError = isError,
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        colors = colors,
                        shape = shape,
                    )
                }
            )
        }
    )

}


@Preview(showBackground = true)
@Composable
fun EKNameFieldPreview() {
    val nameState = SharedTextState()
    ExeatKeeperTheme {
        EKOutlineTextField(
            value = nameState,
            placeholder = R.string.last_name,
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}
