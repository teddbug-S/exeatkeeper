package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.EKFilledButton
import com.example.exeatkeeper.components.EKOutlineTextField
import com.example.exeatkeeper.components.EKPasswordField
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@Composable
fun LoginScreen(navController: NavHostController) {

    // initialize text field values
    var emailValue = SharedTextState("")
    var password = SharedTextState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = 46.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(-38.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(180.dp)
                )

                Text(
                    text = "Exeat Keeper",
                    fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                    fontSize = 48.sp
                )
            }

            Text(
                text = "A better way to keep exeats.",
                fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(topStart = 38.dp, topEnd = 38.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, top = 16.dp, end = 36.dp, bottom = 56.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                    fontSize = 52.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                EKOutlineTextField(
                    placeholder = R.string.email,
                    value = emailValue
                )
                Spacer(modifier = Modifier.height(8.dp))
                EKPasswordField(
                    placeholder = R.string.password,
                    value = password
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Forgot Password?",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(16.dp))
                EKFilledButton(
                    label = R.string.login,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.width(96.dp),
                        thickness = 1.dp
                    )
                    Text(
                        text = "Or",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    HorizontalDivider(
                        modifier = Modifier.width(96.dp),
                        thickness = 1.dp,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                EKFilledButton(
                    label = R.string.sign_up,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inverseSurface,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    ExeatKeeperTheme {
        LoginScreen()
    }
}
