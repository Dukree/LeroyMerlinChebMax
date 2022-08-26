package com.max.leroymerlinchebmax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.max.leroymerlinchebmax.screens.ProductDetails
import com.max.leroymerlinchebmax.ui.theme.LeroyMerlinChebMaxTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeroyMerlinChebMaxTheme {

                MainScreen()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeroyMerlinChebMaxTheme {
        ProductDetails()
    }
}