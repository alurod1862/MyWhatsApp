package com.example.mywhatsapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun novedades() {
    Spacer(modifier = Modifier.size(500.dp))
    Column(Modifier.fillMaxWidth()) {

         Text(text = "Novedades")
    }
}