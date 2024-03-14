package com.example.intellinotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.intellinotes.screen.LoginScreen
import com.example.intellinotes.screen.MainScreen
import com.example.intellinotes.screen.RegisterScreen
import com.example.intellinotes.view_model.LoginViewModel
import com.example.intellinotes.view_model.MainViewModel
import com.example.intellinotes.view_model.RegisterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Main.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Login.route) {
            val loginViewModel = getViewModel<LoginViewModel>()
            val email by loginViewModel.email.collectAsState()
            val password by loginViewModel.password.collectAsState()
            LoginScreen(
                email = email,
                onEmailChange = { loginViewModel.setEmail(it) },
                password = password,
                onPasswordChange = { loginViewModel.setPassword(it) },
                onButtonClick = {
                    loginViewModel.login(email, password)
                    navController.navigate(NavigationItem.Main.route)
                },
                onTextClick = {
                    navController.navigate("register")
                }
            )
        }
        composable(NavigationItem.Register.route) {
            val registerViewModel = getViewModel<RegisterViewModel>()
            val username by registerViewModel.username.collectAsState()
            val email by registerViewModel.email.collectAsState()
            val password by registerViewModel.password.collectAsState()
            RegisterScreen(
                username = username,
                onUsernameChange = { registerViewModel.setUsername(it) },
                email = email,
                onEmailChange = { registerViewModel.setEmail(it) },
                password = password,
                onPasswordChange = { registerViewModel.setPassword(it) },
                onButtonClick = {
                    registerViewModel.register(username, email, password)
                    navController.navigate(NavigationItem.Main.route)
                },
                onTextClick = {
                    navController.navigate("login")
                }
            )
        }
        composable(NavigationItem.Main.route) {
            val mainViewModel = getViewModel<MainViewModel>()
            val expanded by mainViewModel.expanded.collectAsState()
            MainScreen(
                expanded = expanded,
                onExpandedChange = { mainViewModel.setExpanded(it) }
            )
        }
    }
}
