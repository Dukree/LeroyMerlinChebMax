package com.max.leroymerlinchebmax

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.max.leroymerlinchebmax.screens.ProductDetails

import com.max.leroymerlinchebmax.ui.theme.LeroyMerlinChebMaxTheme
import com.max.testcompose.screens.Cart
import com.max.testcompose.screens.MainsScreen
import java.util.*


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

        Column {

        }


    }
}