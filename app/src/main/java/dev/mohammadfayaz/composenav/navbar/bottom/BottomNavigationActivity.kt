package dev.mohammadfayaz.composenav.navbar.bottom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.compose.rememberNavController
import dev.mohammadfayaz.composenav.R
import dev.mohammadfayaz.composenav.theme.ComposeNavTheme

class BottomNavigationActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeNavTheme {
        Scaffold(
          bottomBar = {
            BottomNavigation()
          }
        ) {
          Box(modifier = Modifier.padding(it)) {
            BottomNavActivityGraph(navController = rememberNavController())
          }
        }
      }
    }
  }
}

@Preview
@Composable
private fun Preview() {
  BottomNavigation()
}

data class MenuItem(
  val title: String,
  val icon: Int
)

@Composable
fun BottomNavigation() {
  val menuItems = listOf(
    MenuItem(title = "Home", R.drawable.baseline_person_24),
    MenuItem(title = "Search", R.drawable.baseline_search_24),
    MenuItem(title = "Notifications", R.drawable.baseline_notifications_24),
    MenuItem(title = "Profile", R.drawable.baseline_person_24),
  )
  var selectedIndex by remember { mutableStateOf(0) }
  NavigationBar {
    menuItems.forEachIndexed { index, menuItem ->
      NavigationBarItem(
        selected = index == selectedIndex,
        onClick = {
          selectedIndex = index
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
