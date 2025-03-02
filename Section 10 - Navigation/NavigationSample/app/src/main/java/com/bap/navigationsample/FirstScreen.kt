package com.bap.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FirstScreen(navController: NavController, modifier: Modifier = Modifier) {
    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the First Screen", fontSize = 24.sp)

        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter your name") }
        )

        Spacer(modifier.height(16.dp))

        OutlinedTextField(
            value = age.value,
            onValueChange = { age.value = it },
            label = { Text("Enter your age") }
        )

        Button(onClick = {
            if (name.value.isNotBlank() && age.value.isNotBlank()) {
                navController.navigate("screen2/${name.value}/${age.value.toInt()}")
            }
        }) {
            Text("Go to the Second Screen")
        }
    }
}
