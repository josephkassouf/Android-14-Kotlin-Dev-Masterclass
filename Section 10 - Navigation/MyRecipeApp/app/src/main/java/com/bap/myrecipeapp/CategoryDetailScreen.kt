package com.bap.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetailScreen(category: Category) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbnail",
            modifier = Modifier.aspectRatio(1f)
        )
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(8.dp)
        )
    }
}
