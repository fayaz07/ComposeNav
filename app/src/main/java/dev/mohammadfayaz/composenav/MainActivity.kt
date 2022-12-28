package dev.mohammadfayaz.composenav

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.mohammadfayaz.composenav.data.PostsData
import dev.mohammadfayaz.composenav.navbar.bottom.BottomNavigationActivity
import dev.mohammadfayaz.composenav.theme.ComposeNavTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    loadData()

    setContent {
      ComposeNavTheme {
        ScaffoldBody()
      }
    }
  }

  private fun loadData() {
    CoroutineScope(Dispatchers.IO).launch {
      PostsData.loadData(
        resources.openRawResource(R.raw.posts)
      )
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  private fun ScaffoldBody() {
    val context = LocalContext.current
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text(text = "Compose Navigation Demo") },
        )
      }
    ) {
      Column(
        modifier = Modifier
          .padding(it)
          .padding(horizontal = 16.dp)
          .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Button(onClick = {
          startActivity(Intent(context, BottomNavigationActivity::class.java))
        }) {
          Text(text = "Bottom Navigation Demo")
        }
      }
    }
  }
}
