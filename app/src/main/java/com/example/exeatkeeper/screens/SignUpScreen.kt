package com.example.exeatkeeper.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.exeatkeeper.R
import com.example.exeatkeeper.components.EKFilledButton
import com.example.exeatkeeper.components.EKOutlineTextField
import com.example.exeatkeeper.components.EKPasswordField
import com.example.exeatkeeper.lib.SharedTextState
import com.example.exeatkeeper.navigation.PrivacyPolicyScreenClass
import com.example.exeatkeeper.navigation.TermsAndConditionsScreenClass


@Composable
fun TermsAndPrivacyText(
    onTermsClicked: (LinkAnnotation) -> Unit,
    onPrivacyClicked: (LinkAnnotation) -> Unit
) {
    val annotatedText = buildAnnotatedString {
        append("By continuing, you agree to our ")

        withLink(
            LinkAnnotation.Clickable(
                tag = "TERMS", linkInteractionListener = onTermsClicked, style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primary

                )
            )
        ) {
            append("Terms Of Use")
        }

        append(" and ")

        withLink(
            LinkAnnotation.Clickable(
                tag = "TERMS", linkInteractionListener = onPrivacyClicked, style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        ) {
            append("Privacy Policy")
        }
    }

    Text(
        text = annotatedText,
        style = MaterialTheme.typography.labelLarge,
        textAlign = TextAlign.Center
    )

}


@Composable
fun SignUpScreen(navController: NavHostController) {
    // initialize text field values
    val firstName = SharedTextState("")
    val lastName = SharedTextState("")
    val password = SharedTextState("")
    val confirmPassword = SharedTextState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Surface(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(bottomStart = 36.dp, bottomEnd = 36.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 0.dp, bottom = 36.dp, start = 36.dp, end = 36.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(-(8).dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.sign_up_rafiki),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.sign_up),
                        fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                        fontSize = 52.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                    Text(
                        stringResource(R.string.sign_up_description),
                        fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(horizontal = 46.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            stringResource(R.string.personal),
                            style = MaterialTheme.typography.labelLarge
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            item {
                                EKOutlineTextField(
                                    value = firstName,
                                    placeholder = R.string.first_name
                                )
                            }
                            item {
                                EKOutlineTextField(
                                    value = lastName,
                                    placeholder = R.string.last_name
                                )
                            }
                        }
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            "Authentication",
                            style = MaterialTheme.typography.labelLarge
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            EKPasswordField(value = password, placeholder = R.string.password)
                            EKPasswordField(
                                value = confirmPassword,
                                placeholder = R.string.confirm_password
                            )
                        }
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 36.dp)
        ) {
            EKFilledButton(
                label = R.string.continue_text,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            Text(
                stringResource(R.string.already_a_member),
                style = MaterialTheme.typography.labelLarge
            )
            EKFilledButton(
                label = R.string.login,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.inverseSurface,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            TermsAndPrivacyText(
                onTermsClicked = { navController.navigate(TermsAndConditionsScreenClass) },
                onPrivacyClicked = { navController.navigate(PrivacyPolicyScreenClass) })
        }
    }
}
