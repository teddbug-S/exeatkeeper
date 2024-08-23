package com.example.exeatkeeper.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun EKRoundedCheckBox(
    label: String,
    checked: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    val animatedBoxColor by animateColorAsState(
        targetValue = if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
        animationSpec = tween(durationMillis = 300) // Adjust the duration as needed
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(24.dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(animatedBoxColor, shape = RoundedCornerShape(8.dp))
                .clickable { onValueChange(!checked) }, // Toggle the checked state
        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.padding(3.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Text(label, style = MaterialTheme.typography.labelLarge, fontSize = 16.sp)
    }
}


@Preview
@Composable
fun PreviewEKRoundedCheckBox() {
    ExeatKeeperTheme {

        val checked = remember {
            mutableStateOf(true)
        }

        EKRoundedCheckBox(
            label = "Add students manually",
            checked = checked.value,
            onValueChange = { value -> checked.value = value }
        )
    }
}