package com.example.mywhatsapp.ui.theme

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mywhatsapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun chats() {
    val chats = listOf(
        Chat("Departamento Informatica", "Juan", R.drawable.photo),
        Chat("Departamento Informatica", "Arturo", R.drawable.photo1),
        Chat("Departamento Marketing", "Pedro", R.drawable.photo2),
        Chat("Departamento Marketing", "Maria", R.drawable.photo3),
        Chat("Departamento Marketing", "Ana", R.drawable.photo4),
        Chat("Departamento Finanzas", "Jose", R.drawable.photo5),
        Chat("Departamento Finanzas", "Fabio", R.drawable.photo6),
        Chat("Departamento Administracion", "Pablo", R.drawable.photo7),
        Chat("Departamento Logistica", "Marc", R.drawable.photo8),
        Chat("Departamento Logistica", "Pepe", R.drawable.photo9)
    )

    val groupedChats = chats.groupBy { it.departamento }

    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        state = listState
    ) {
        groupedChats.forEach { (departamento, chats) ->
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    Text(
                        text = departamento,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 2.dp, top = 5.dp, bottom = 5.dp),
                        fontSize = 15.sp
                    )
                }
            }


            chats.forEach { chat ->
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .pointerInput(true) {
                                detectTapGestures(
                                    onLongPress = {

                                        //Falta por hacer
                                    }
                                )
                            }
                    ) {
                        Image(
                            painter = painterResource(id = chat.imageVector),
                            contentDescription = null,
                            modifier = Modifier
                                .size(95.dp)
                                .padding(10.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = chat.nombre,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 33.sp
                        )
                    }
                }
            }
        }
    }
}
