package com.example.mywhatsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.example.mywhatsapp.ui.theme.MyWhatsAppTheme
import com.example.mywhatsapp.ui.theme.chats
import com.example.mywhatsapp.ui.theme.llamadas
import com.example.mywhatsapp.ui.theme.novedades
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                MyWhatsAppTheme {
                        Scaffold(
                            topBar = {MyTopAppBar()},
                            floatingActionButton = {fabHeart()}
                        ) {
                                innerPading -> tabs(innerPading)
                        }
                }
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun fabHeart(){
    val image = AnimatedImageVector.animatedVectorResource(id = R.drawable.ad_heart)
    var atEnd by remember { mutableStateOf(false) }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            rememberAnimatedVectorPainter(animatedImageVector = image, atEnd = atEnd),""
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){

    TopAppBar(
        title = { Text(text = "My WhatsApp", color = Color.White) },
        actions = {
            IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = "Ver más",
                tint = Color.White
            )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Ver más",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary
        )
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun tabs(innerPadding: PaddingValues) {
    val titles = listOf("Chats", "Pause/Start", "Smile")
    val pagerState = rememberPagerState()
    val courtine = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.padding(innerPadding),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {courtine.launch{ pagerState.animateScrollToPage(index) }},
                    text = {
                        Text(
                            text = title,
                            color = Color.White,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth(),pageCont = titles.size) { page ->
            when (page) {
                0 -> chats()
                1 -> novedades()
                2 -> llamadas()
            }
        }
    }
}


