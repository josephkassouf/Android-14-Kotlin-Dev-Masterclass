package com.bap.musicapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bap.musicapp.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun MainView() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val viewModel: MainViewModel = viewModel()

    // Navigation Controller and Current Route
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Dialog State for "Add Account"
    val dialogOpen = remember { mutableStateOf(false) }

    // Dynamically update the title based on the current route
    val title = when (currentRoute) {
        Screen.DrawerScreen.Account.dRoute -> "Account"
        Screen.DrawerScreen.Subscription.dRoute -> "Subscription"
        "add_account" -> "Add Account"
        else -> "Music App"
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(title) },
                modifier = Modifier.statusBarsPadding(),
                navigationIcon = {
                    IconButton(onClick = {
                        // Open Drawer
                        scope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = {
            LazyColumn(
                modifier = Modifier.padding(16.dp).statusBarsPadding()
            ) {
                items(screensInDrawer) { item ->
                    DrawerItem(
                        selected = currentRoute == item.dRoute,
                        item = item
                    ) {
                        if (item.dRoute == "add_account") {
                            // Show the Add Account Dialog
                            dialogOpen.value = true
                        } else {
                            // Navigate to other routes
                            navController.navigate(item.dRoute) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true }
                        }
                        // Close the drawer
                        scope.launch { scaffoldState.drawerState.close() }
                    }
                }
            }
        }
    ) { paddingValues ->
        // Navigation and Add Account Dialog
        Navigation(navController = navController, viewModel = viewModel, pd = paddingValues)
        AccountDialog(dialogOpen = dialogOpen)
    }
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClick: () -> Unit
) {
    val background = if (selected) Color.DarkGray else Color.White
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable { onDrawerItemClick() }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTile,
            modifier = Modifier.padding(end = 8.dp, top = 4.dp)
        )
        Text(
            text = item.dTile,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd: PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.dRoute,
        modifier = Modifier.padding(pd)
    ) {
        composable(Screen.DrawerScreen.Account.dRoute) {
            AccountView()
        }
        composable(Screen.DrawerScreen.Subscription.dRoute) {
            SubscriptionView()
        }
    }
}
