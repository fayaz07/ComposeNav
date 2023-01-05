package dev.mohammadfayaz.composenav.navbar.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mohammadfayaz.composenav.navbar.bottom.screens.HomeScreen
import dev.mohammadfayaz.composenav.navbar.bottom.screens.NotificationsScreen
import dev.mohammadfayaz.composenav.navbar.bottom.screens.ProfileScreen
import dev.mohammadfayaz.composenav.navbar.bottom.screens.SearchScreen

@Composable
fun BottomNavActivityGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = BottomNavActivityRoutes.home
  ) {
    composable(BottomNavActivityRoutes.home) {
      HomeScreen()
    }
    composable(BottomNavActivityRoutes.search) {
      SearchScreen()
    }
    composable(BottomNavActivityRoutes.notifications) {
      NotificationsScreen()
    }
    composable(BottomNavActivityRoutes.profile) {
      ProfileScreen()
    }
  }
}
