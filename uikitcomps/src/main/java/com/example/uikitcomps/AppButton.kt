package com.example.uikitcomps

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}

// 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
// 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