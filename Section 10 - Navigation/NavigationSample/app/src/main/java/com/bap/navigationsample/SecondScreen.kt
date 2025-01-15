package com.bap.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SecondScreen(name: String?, age: Int?, navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the Second Screen", fontSize = 24.sp)
        Text("Welcome $name, you are $age years old", fontSize = 24.sp)

        Button(onClick = {
            navController.navigate("Screen1")
        }) {
            Text("Go to First Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    SecondScreen(name = "Test", age = 19, navController = rememberNavController())
}
