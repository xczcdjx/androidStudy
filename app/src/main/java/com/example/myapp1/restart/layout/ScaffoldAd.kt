package com.example.myapp1.restart.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Museum
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.material.TopAppBar as TopBarLegal

data class BotData(val t: String, val i: Short, val p: String?, val ic: ImageVector)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ScaffoldAd() {
    val botItems = listOf(
        BotData("Home", 0, "/home", Icons.Default.Home),
        BotData("Search", 1, "/Search", Icons.Default.Search),
        BotData("User", 2, null, Icons.Default.AccountCircle)
    )
    var navIndex by remember {
        mutableStateOf<Short>(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "主页") }, navigationIcon = {
                Icon(imageVector = Icons.Default.NavigateBefore, contentDescription = null)
            }, actions = {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            })
        },
        bottomBar = {
            // 由原来的BottomNavigation更换为NavigationBar，BottomNavigationItem改为NavigationBarItem
            NavigationBar {
                botItems.forEachIndexed { index, botData ->
                    NavigationBarItem(
                        selected = navIndex == botData.i,
                        onClick = { navIndex = botData.i },
                        icon = {
                            BadgedBox(badge = {
                                Card(
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(text = "99+", modifier = Modifier.background(Color.Red))
                                }
                            }) {
                                Icon(imageVector = botData.ic, contentDescription = null)
                            }
                        },
                        label = {
                            Text(text = botData.t)
                        })
                }
            }
            /*BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    botItems.forEachIndexed { index, botData ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = botData.ic, contentDescription = null)
                            Text(text = botData.t)
                        }
                    }
                }
            }*/
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = {
                    Icon(
                        imageVector = Icons.Default.SupervisedUserCircle,
                        contentDescription = null
                    )
                },
                text = { Text("Button") },
                onClick = { /*TODO*/ })
        },
        // 侧边浮动图标
        floatingActionButtonPosition = FabPosition.End,
    ) { pad -> // 带有边距参数
        Box(modifier = Modifier.padding(pad)) {
            Text(text = "Content ${botItems[navIndex.toInt()].t}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ScaffoldAd2() {
    val botItems = listOf(
        BotData("Home", 0, "/home", Icons.Default.Museum),
        BotData("Search", 1, "/Search", Icons.Default.Audiotrack),
        BotData("User", 2, null, Icons.Default.AccountCircle)
    )
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackBarHost = remember {
        SnackbarHostState()
    }
    var navIndex by remember {
        mutableStateOf<Short>(0)
    }
    // 新版将drawer移除出scaffold
    ModalNavigationDrawer(
//        modifier = Modifier.fillMaxWidth(),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "我是内容")
            }
        },
        // 遮罩颜色
        scrimColor = Color.Blue
    ) {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "主页") }, navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }, actions = {
                IconButton(onClick = {
                    scope.launch {
                        snackBarHost.showSnackbar("展示信息")
                    }
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            })
        }, bottomBar = {
            // 由原来的BottomNavigation更换为NavigationBar，BottomNavigationItem改为NavigationBarItem
            NavigationBar {
                botItems.forEachIndexed { index, botData ->
                    NavigationBarItem(
                        selected = navIndex == botData.i,
                        onClick = { navIndex = botData.i },
                        icon = {
                            BadgedBox(badge = {
                                Card(
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(text = "99+", modifier = Modifier.background(Color.Red))
                                }
                            }) {
                                Icon(imageVector = botData.ic, contentDescription = null)
                            }
                        },
                        label = {
                            Text(text = botData.t)
                        })
                }
            }
        }, snackbarHost = {
            SnackbarHost(hostState = snackBarHost)
        }
        ) { pad -> // 带有边距参数
            Box(modifier = Modifier.padding(pad)) {
                Text(text = "Content ${botItems[navIndex.toInt()].t}")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ScaffoldAd3() {
    val scope = rememberCoroutineScope()
    val selection = remember { mutableStateOf(1) }
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    LaunchedEffect(scaffoldState) {
        scaffoldState.reveal()
    }
    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            TopBarLegal(
                title = { Text("Backdrop scaffold") },
                navigationIcon = {
                    if (scaffoldState.isConcealed) {
                        IconButton(onClick = { scope.launch { scaffoldState.reveal() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Localized description")
                        }
                    } else {
                        IconButton(onClick = { scope.launch { scaffoldState.conceal() } }) {
                            Icon(Icons.Default.Close, contentDescription = "Localized description")
                        }
                    }
                },
                actions = {
                    var clickCount by remember { mutableStateOf(0) }
                    IconButton(
                        onClick = {
                            // show snackbar as a suspend function
                            scope.launch {
                                scaffoldState.snackbarHostState
                                    .showSnackbar("Snackbar #${++clickCount}")
                            }
                        }
                    ) {
                        Icon(Icons.Default.Favorite, contentDescription = "Localized description")
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent
            )
        },
        backLayerContent = {
            LazyColumn {
                items(if (selection.value >= 3) 3 else 5) {
                    ListItem(
                        Modifier.clickable {
                            selection.value = it
                            scope.launch { scaffoldState.conceal() }
                        },
                        text = { Text("Select $it") }
                    )
                }
            }
        },
        frontLayerContent = {
            Text("Selection: ${selection.value}")
            LazyColumn {
                items(50) {
                    ListItem(
                        text = { Text("Item $it") },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class, )
@Preview(showBackground = true)
@Composable
fun ScaffoldAd4() {
    val scope = rememberCoroutineScope()
    val scaffoldState =rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        scaffoldState=scaffoldState,
        topBar = {
        TopAppBar(title = { Text(text = "主页") }, navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        }, actions = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        })
    }, sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Swipe up to expand sheet")
            }
            Column (
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "展示")
                Spacer(modifier = Modifier.padding(10.dp))
                TextButton(onClick = {
                    scope.launch {
                        if (scaffoldState.bottomSheetState.isVisible){
                            scaffoldState.bottomSheetState.hide()
                        }
                    }
                }) {
                    Text(text = "Close")
                }
            }
    }, sheetPeekHeight = 128.dp) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(100) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            }
        }
    }
   /* ModalBottomSheetLayout(sheetContent = ) {

    }*/
}