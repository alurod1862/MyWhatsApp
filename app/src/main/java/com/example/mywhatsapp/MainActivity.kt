package com.example.mywhatsapp

import AnimatedPausePlayIcon
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
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
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                MyWhatsAppTheme {
                        Scaffold(
                            topBar = {MyTopAppBar()},
                            floatingActionButton = {
                                FloatingActionButton(
                                    onClick = { },
                                    containerColor = Color(0xFF00695C),
                                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                                ) {
                                    FabHeart()
                                }
                            }
                        ) {
                                innerPading -> Tabs(innerPading)
                        }
                }
        }
    }
}


@OptIn(ExperimentalAnimationGraphicsApi::class, ExperimentalAnimationGraphicsApi::class)
@Composable
fun FabHeart(){
    val image = AnimatedImageVector.animatedVectorResource(R.drawable.ad_rotacion)
    var atEnd by remember { mutableStateOf(false) }
    Image(
        painter = rememberAnimatedVectorPainter(image, atEnd),
        contentDescription = "VectorDrawable",
        modifier = Modifier.clickable {
            atEnd = !atEnd
        },
        //contentScale = ContentScale.Crop
    )
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
fun Tabs(innerPadding: PaddingValues) {
    val titles = listOf("Chats", "Pause/Start", "Smile")
    var pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        titles.size
    }
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
        HorizontalPager(state = pagerState) { page ->
        when (page) {
                0 -> chats()
                1 -> AnimatedPausePlayIcon()
                2 -> SmileFace()
            }
        }
    }
}


