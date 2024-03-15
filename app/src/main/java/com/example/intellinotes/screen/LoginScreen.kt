package com.example.intellinotes.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.intellinotes.R
import com.example.intellinotes.components.DividerText
import com.example.intellinotes.components.EmailTextField
import com.example.intellinotes.components.HeadingText
import com.example.intellinotes.components.NormalButton
import com.example.intellinotes.components.NormalClickableText
import com.example.intellinotes.components.PasswordTextField
import com.example.intellinotes.state.LoginState

@Composable
fun LoginScreen(
    navController: NavController,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    state: LoginState,
    onButtonClick: () -> Unit,
    onTextClick: (String) -> Unit
) {

    when (state) {
        LoginState.Empty -> {
        }

        is LoginState.Error -> {
        }

        LoginState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        LoginState.Success -> {
            navController.navigate("main")
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 28.dp, end = 28.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            HeadingText(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.padding(20.dp))

            EmailTextField(
                value = email,
                labelValue = stringResource(id = R.string.email),
                onChange = onEmailChange,
                painterResource = Icons.Default.Email
            )

            Spacer(modifier = Modifier.padding(10.dp))

            PasswordTextField(
                value = password,
                labelValue = stringResource(id = R.string.password),
                onChange = onPasswordChange,
                painterResource = Icons.Default.Lock
            )

            Spacer(modifier = Modifier.padding(10.dp))

            NormalButton(
                value = stringResource(id = R.string.login),
                onClick = {
                    onButtonClick()
                    navController.navigate("main")
                }
            )

            DividerText(value = stringResource(id = R.string.or))
            NormalClickableText(
                initialText = "Don\'t have an account yet?",
                mainText = stringResource(id = R.string.register),
                onTextSelected = onTextClick
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = NavController(LocalContext.current),
        email = "email",
        onEmailChange = {},
        password = "password",
        onPasswordChange = {},
        state = LoginState.Loading,
        onButtonClick = {},
        onTextClick = {}
    )
}
