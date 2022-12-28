package dev.mohammadfayaz.composenav.navbar.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mohammadfayaz.composenav.navbar.bottom.screens.HomeScreen

@Composable
fun BottomNavActivityGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = BottomNavActivityRoutes.home
  ) {
    composable(BottomNavActivityRoutes.home) {
      HomeScreen()
    }
  }
}
