package dev.mohammadfayaz.composenav.navbar.bottom.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dev.mohammadfayaz.composenav.composables.PostWidget
import dev.mohammadfayaz.composenav.data.PostsData

@Composable
fun HomeScreen() {
  LazyColumn {
    items(PostsData.data) {
      PostWidget(post = it) {

      }
    }
  }
}
