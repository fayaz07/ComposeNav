package dev.mohammadfayaz.composenav.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import dev.mohammadfayaz.composenav.data.PostModel

@Composable
fun PostWidget(post: PostModel, onPostClicked: () -> Unit) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(260.dp)
      .padding(8.dp)
      .clickable {
        onPostClicked()
      },
    shape = RoundedCornerShape(8.dp),
  ) {
    Column {
      Row(modifier = Modifier.padding(bottom = 4.dp, top = 4.dp)) {
        SubcomposeAsyncImage(
          model = post.avatar,
          contentDescription = post.username,
          loading = {
            MySpinner()
          },
          modifier = Modifier
            .padding(4.dp)
            .padding(end = 8.dp)
            .height(32.dp)
            .width(32.dp)
            .clip(CircleShape)
        )
        Text(text = post.username, style = MaterialTheme.typography.titleLarge)
      }
      SubcomposeAsyncImage(
        modifier = Modifier.fillMaxWidth(),
        model = post.image,
        contentScale = ContentScale.FillWidth,
        contentDescription = "Post by ${post.username}",
        loading = {
          MySpinner()
        }
      )
    }
  }
}