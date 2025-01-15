package com.bap.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bap.wishlistapp.data.DummyWish
import com.bap.wishlistapp.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Scaffold(
        topBar = { AppBarView(title = "WishList", {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
        }) },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                onClick = {
                    Toast.makeText(context, "Add Wish", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.AddScreen.route)
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Wish")
            }
        }
    ) {
        LazyColumn(
            modifier.fillMaxSize().padding(it)
        ) {
            items(DummyWish.wishList) {
                wish ->  WishItem(wish = wish) {
            }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 8.dp, end = 8.dp).clickable {
            onClick()
        },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(wish.title, fontWeight =  FontWeight.ExtraBold)
            Text(wish.description)
        }
    }
}