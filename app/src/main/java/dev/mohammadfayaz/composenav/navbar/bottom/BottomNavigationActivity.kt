package dev.mohammadfayaz.composenav.navbar.bottom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.mohammadfayaz.composenav.R
import dev.mohammadfayaz.composenav.theme.ComposeNavTheme

class BottomNavigationActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeNavTheme {
        val navController = rememberNavController()
        Scaffold(
          bottomBar = {
            BottomNavigation(navController)
          }
        ) {
          Box(modifier = Modifier.padding(it)) {
            BottomNavActivityGraph(navController = navController)
          }
        }
      }
    }
  }
}

@Preview
@Composable
private fun Preview() {
  BottomNavigation(rememberNavController())
}

data class MenuItem(
  val title: String,
  val icon: Int,
  val route: String
)

@Composable
fun BottomNavigation(navController: NavHostController) {
  val menuItems = listOf(
    MenuItem(
      title = "Home",
      icon = R.drawable.baseline_person_24,
      route = BottomNavActivityRoutes.home
    ),
    MenuItem(
      title = "Search",
      icon = R.drawable.baseline_search_24,
      route = BottomNavActivityRoutes.search
    ),
    MenuItem(
      title = "Notifications",
      icon = R.drawable.baseline_notifications_24,
      route = BottomNavActivityRoutes.notifications
    ),
    MenuItem(
      title = "Profile",
      icon = R.drawable.baseline_person_24,
      route = BottomNavActivityRoutes.profile
    ),
  )
  var selectedIndex by remember { mutableStateOf(0) }
//  val state = remember { HashMap<String, Bundle?>() }
  NavigationBar {
    menuItems.forEachIndexed { index, menuItem ->
      NavigationBarItem(
        selected = index == selectedIndex,
        onClick = {
          selectedIndex = index
          navController.backQueue.print()
//          state[menuItem.route] = navController.saveState()
          navController.navigate(menuItem.route) {
            popUpTo(navController.graph.findStartDestination().id) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
//          state[menuItem.route]?.let {
//            navController.restoreState(it)
//          }
        },
        label = {
          Text(text = menuItem.title)
        },
        icon = {
          Image(painterResource(id = menuItem.icon), menuItem.title)
        }
      )
    }
  }
}

fun ArrayDeque<NavBackStackEntry>.print() {
  for (i in 0 until size) {
    print(get(i).destination.route + " -> ")
  }
  println()
}
