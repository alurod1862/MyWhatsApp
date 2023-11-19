package com.example.mywhatsapp.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mywhatsapp.R

@Composable
fun SmileFace() {
    var isHappy by remember { mutableStateOf(false) }

    val mouthIcon: Painter = if (isHappy) {
        painterResource(id = R.drawable.face)
    } else {
        painterResource(id = R.drawable.face2)
    }

    Column(
        modifier = Modifier
            .clickable {
                isHappy = !isHappy
            }
            .animateContentSize()
    ) {
        Image(
            painter = mouthIcon,
            contentDescription = if (isHappy) "Smile Mouth" else "Sad Mouth",
            modifier = Modifier
                .size(500.dp)
        )
    }
}

