package com.example.uikitcomps

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextField(
    text: String,
    modifier: Modifier
){
    Text(text, modifier)
}