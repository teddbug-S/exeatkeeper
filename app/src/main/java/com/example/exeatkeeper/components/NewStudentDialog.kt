package com.example.exeatkeeper.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.exeatkeeper.R
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun NewStudentDialog(onDismissRequest: () -> Unit = {}) {

    val studentName = SharedTextState("")
    val grade = SharedTextState("")
    val parentNumber1 = SharedTextState("")
    val parentNumber2 = SharedTextState("")

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text("New Student", style = MaterialTheme.typography.labelLarge, fontSize = 20.sp)
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text("Student")
                    EKOutlineTextField(value = studentName, placeholder = R.string.student_name)
                    EKOutlineTextField(value = grade, placeholder = R.string.grade)
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text("Parent")
                    EKOutlineTextField(
                        value = parentNumber1,
                        placeholder = R.string.father_s_number
                    )
                    EKOutlineTextField(
                        value = parentNumber2,
                        placeholder = R.string.mother_s_number
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    TextButton(onClick = { onDismissRequest() }) {
                        Text(
                            "Cancel",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Create", style = MaterialTheme.typography.labelMedium)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewNewStudentDialog() {
    ExeatKeeperTheme {
        NewStudentDialog()
    }
}
