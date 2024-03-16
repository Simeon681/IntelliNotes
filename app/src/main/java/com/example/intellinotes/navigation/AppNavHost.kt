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
import com.example.intellinotes.screen.MaterialScreen
import com.example.intellinotes.screen.PlanScreen
import com.example.intellinotes.screen.QuestionsScreen
import com.example.intellinotes.screen.RegisterScreen
import com.example.intellinotes.screen.SummaryScreen
import com.example.intellinotes.view_model.LoginViewModel
import com.example.intellinotes.view_model.MainViewModel
import com.example.intellinotes.view_model.RegisterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onTextSelect: () -> Unit,
    startDestination: String = NavigationItem.Login.route
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
            val materials by mainViewModel.materials.collectAsState()

            MainScreen(
                navController,
                expanded = expanded,
                onExpandedChange = { mainViewModel.setExpanded(it) },
                onTextSelect = onTextSelect,
                materials = materials,
                onMusicSelect = {
                    mainViewModel.sendVoice(it)
                },
                onDocSelect = {
                    mainViewModel.sendText(it)
                },
                onMockSelect = {
                    mainViewModel.sendMock()
                }
            )
        }
        composable("${NavigationItem.Material.route}/{id}") {
            val id = it.arguments?.getString("id")
            val mainViewModel = getViewModel<MainViewModel>()
            val material by mainViewModel.material.collectAsState()
            MaterialScreen(
                onGetMaterial = { mainViewModel.getMaterial(id.toString()) },
                material = material ?: error("Material not found"),
                onClick1 = { navController.navigate(NavigationItem.Plan.route) },
                onClick2 = { navController.navigate(NavigationItem.Summary.route) },
                onClick3 = { navController.navigate(NavigationItem.Questions.route) }
            )
        }
        composable(NavigationItem.Plan.route) {
            val mainViewModel = getViewModel<MainViewModel>()
            val material by mainViewModel.material.collectAsState()
            PlanScreen(
                material = material ?: error("Material not found")
            )
        }
        composable(NavigationItem.Summary.route) {
            val mainViewModel = getViewModel<MainViewModel>()
            val material by mainViewModel.material.collectAsState()
            SummaryScreen(
                material = material ?: error("Material not found")
            )
        }

        composable(NavigationItem.Questions.route) {
            val mainViewModel = getViewModel<MainViewModel>()
            val material by mainViewModel.material.collectAsState()
            QuestionsScreen(
                material = material ?: error("Material not found")
            )
        }
    }
}
