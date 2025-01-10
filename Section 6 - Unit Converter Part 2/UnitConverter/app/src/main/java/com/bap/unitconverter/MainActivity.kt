package com.bap.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    // State management for dropdowns and input/output
    var firstUnit by remember { mutableStateOf("Centimeters") }
    var secondUnit by remember { mutableStateOf("Meters") }
    var inputValue by remember { mutableStateOf("") }
    var dropdown1Expanded by remember { mutableStateOf(false) }
    var dropdown2Expanded by remember { mutableStateOf(false) }

    // Conversion factors map
    val conversionFactors = mapOf(
        "Centimeters to Meters" to 0.01,
        "Meters to Centimeters" to 100.0,
        "Meters to Feet" to 3.28084,
        "Feet to Meters" to 0.3048,
        "Feet to Millimeters" to 304.8,
        "Millimeters to Feet" to 0.00328084,
        "Centimeters to Millimeters" to 10.0,
        "Millimeters to Centimeters" to 0.1,
        "Centimeters to Feet" to 0.0328084,
        "Feet to Centimeters" to 30.48,
        "Meters to Millimeters" to 1000.0,
        "Millimeters to Meters" to 0.001
    )

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        color = Color.Red
    )


    // Calculate result
    val result = if (inputValue.isNotEmpty()) {
        val factor = conversionFactors["$firstUnit to $secondUnit"] ?: 1.0
        inputValue.toDoubleOrNull()?.times(factor)?.toString() ?: "Invalid input"
    } else ""

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier.height(16.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter Value") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            // First Unit Dropdown
            Box {
                Button(onClick = { dropdown1Expanded = true }) {
                    Text(firstUnit)
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
            // Second Unit Dropdown
            Box {
                Button(onClick = { dropdown2Expanded = true }) {
                    Text(secondUnit)
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

        // Result
        Text("Result: $result", style = customTextStyle)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}
