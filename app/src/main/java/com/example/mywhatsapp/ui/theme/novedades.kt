import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mywhatsapp.R

@Composable
fun AnimatedPausePlayIcon() {
    var isPlaying by remember { mutableStateOf(false) }


    val iconPainter: Painter = if (isPlaying) {
        painterResource(id = R.drawable.pause2_icon)
    } else {
        painterResource(id = R.drawable.pause_icon)
    }

    Column(
        modifier = Modifier
            .clickable {
                isPlaying = !isPlaying
            }
            .wrapContentSize()
    ) {
        Image(
            painter = iconPainter,
            contentDescription = if (isPlaying) "Play Icon" else "Pause Icon",
            modifier = Modifier
                .size(500.dp)
        )
    }
}
