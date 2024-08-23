package com.example.exeatkeeper.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.R


@Composable
fun EKFilledButton(
    @StringRes label: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = colors
    ) {
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.labelLarge,
            fontSize = 18.sp
        )
    }
}


@Preview
@Composable
fun EKFilledButtonPreview() {
    EKFilledButton(label = R.string.login)
}