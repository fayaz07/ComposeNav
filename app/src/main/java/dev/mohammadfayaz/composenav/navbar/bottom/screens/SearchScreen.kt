package dev.mohammadfayaz.composenav.navbar.bottom.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mohammadfayaz.composenav.composables.PostWidget
import dev.mohammadfayaz.composenav.data.PostModel
import dev.mohammadfayaz.composenav.data.PostsData

@Preview
@Composable
private fun Preview() {
  SearchScreen()
}

@Composable
fun SearchScreen() {
  val query = remember {
    mutableStateOf("")
  }
  val list = remember {
    mutableStateOf<List<PostModel>>(emptyList())
  }
  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    SearchField(query, list)
    PostsList(list)
  }
}

@Composable
private fun PostsList(list: MutableState<List<PostModel>>) {
  LazyColumn {
    items(list.value) {
      PostWidget(post = it) {

      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchField(query: MutableState<String>, list: MutableState<List<PostModel>>) {
  OutlinedTextField(
    modifier = Modifier
      .padding(horizontal = 16.dp)
      .fillMaxWidth()
      .padding(top = 32.dp),
    value = query.value,
    onValueChange = {
      query.value = it
    },
    label = {
      Text(text = "Search")
    },
    trailingIcon = {
      IconButton(onClick = {
        list.value = PostsData.data.filter { postModel ->
          postModel.caption.contains(query.value, true)
        }
      }) {
        Icon(Icons.Default.Search, "Search button")
      }
    }
  )
}
