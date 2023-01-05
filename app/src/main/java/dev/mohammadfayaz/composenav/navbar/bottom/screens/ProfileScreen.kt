package dev.mohammadfayaz.composenav.navbar.bottom.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Preview
@Composable
private fun Preview() {
  ProfileScreen()
}

@Composable
fun ProfileScreen() {
  val config = LocalConfiguration.current
  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    Box {
      AsyncImage(
        model = "https://images.pexels.com/photos/2922656/pexels-photo-2922656.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        contentDescription = "background-image",
        alpha = 0.5f,
        modifier = Modifier.clip(
          RoundedCornerShape(
            bottomStart = config.screenWidthDp.dp,
            bottomEnd = 64.dp
          )
        )
      )
      ConstrainedArc(
        screenWidthDp = config.screenWidthDp
      )
      AsyncImage(
        model = "https://raw.githubusercontent.com/fayaz07/JSON-to-UI/image/cat.png",
        contentDescription = "cat profile picture",
        modifier = Modifier
          .align(Alignment.TopCenter)
          .padding(top = (config.screenWidthDp * 0.15).dp)
          .size((config.screenWidthDp * .4).dp)
          .clip(CircleShape),
      )
    }
  }
}

@Composable
private fun ConstrainedArc(screenWidthDp: Int) {
  BoxWithConstraints {
    ArcWithGradient(screenWidthDp)
  }
}

@Composable
fun ArcWithGradient(screenWidthDp: Int) {
  val brush = Brush.horizontalGradient(
    colors = listOf(
      Color(0xffF775A4),
      Color(0xffF78D75),
    ),
    tileMode = TileMode.Decal
  )
  Canvas(modifier = Modifier.size(screenWidthDp.dp)) {
    drawCircle(
      brush = brush,
      radius = screenWidthDp.toFloat() * 2,
      center = Offset(
        screenWidthDp.toFloat() * 1.95f,
        -50.0f
      ),
      alpha = 0.85f
    )
  }
}