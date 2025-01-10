package com.bap.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bap.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { paddingValues ->
                    UnitConverter(Modifier.padding(paddingValues))
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    // State management for dropdowns
    var firstUnit by remember { mutableStateOf("Select Unit") }
    var secondUnit by remember { mutableStateOf("Select Unit") }
    var dropdown1Expanded by remember { mutableStateOf(false) }
    var dropdown2Expanded by remember { mutableStateOf(false) }
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter")
        Spacer(modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = { })
        Spacer(modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { dropdown1Expanded = true}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = dropdown1Expanded, onDismissRequest = { dropdown1Expanded = false }) {
                    listOf("Centimeters", "Meters", "Feet", "Millimeters").forEach { unit ->
                        DropdownMenuItem(
                            text = { Text(unit) },
                            onClick = {
                                firstUnit = unit
                                dropdown1Expanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier.width(16.dp))
            Box {
                Button(onClick = { dropdown2Expanded = true}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = dropdown2Expanded, onDismissRequest = { dropdown2Expanded = false }) {
                    listOf("Centimeters", "Meters", "Feet", "Millimeters").forEach { unit ->
                        DropdownMenuItem(
                            text = { Text(unit) },
                            onClick = {
                                secondUnit = unit
                                dropdown2Expanded = false
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier.height(16.dp))
        Text("Result: ", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}
