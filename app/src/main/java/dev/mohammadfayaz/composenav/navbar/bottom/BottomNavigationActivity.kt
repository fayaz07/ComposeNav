package dev.mohammadfayaz.composenav.navbar.bottom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.mohammadfayaz.composenav.theme.ComposeNavTheme

class BottomNavigationActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeNavTheme {

      }
    }
  }
}
