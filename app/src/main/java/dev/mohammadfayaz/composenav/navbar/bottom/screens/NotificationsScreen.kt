package dev.mohammadfayaz.composenav.navbar.bottom.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NotificationsScreen() {
  LazyColumn {
    items(100) {
      Card(
        elevation = CardDefaults.cardElevation(
          defaultElevation = 8.dp
        ),
        modifier = Modifier.padding(8.dp)
      ) {
        Column(
          modifier = Modifier.padding(16.dp)
        ) {
          Text(text = "Notifications $it", style = MaterialTheme.typography.titleMedium)
          Text(
            text = "Full detail about notification $it. This is about notification $it. You can click on it.",
            style = MaterialTheme.typography.bodyMedium
          )
        }
      }
    }
  }
}
