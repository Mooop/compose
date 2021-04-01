package com.example.androiddevchallenge

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PlantThemes
import com.example.androiddevchallenge.data.Plants

import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Home()
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun Home() {
    // A surface container using the 'background' color from the theme
    Surface(color = colors.background) {

        var search by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp, 0.dp, 8.dp, 0.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = search,
                onValueChange = {
                    Log.d(HomeActivity::class.simpleName, "Search:$it")
                    search = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(
                        width = 1.dp,
                        color = colors.onPrimary,
                        shape = shapes.small
                    ),
                placeholder = {
                    Text(
                        text = "Search",
                        style = typography.body1,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    textColor = colors.onPrimary
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                },
                singleLine = true
            )

            Text(
                text = "Browse themes",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp),
                style = typography.h1,
                color = colors.onPrimary,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(PlantThemes) { plantTheme ->
                        ThemeCard(plantTheme = plantTheme)
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    color = colors.onPrimary,
                )
                Icon(
                    imageVector = Icons.Filled.FilterList,
                    contentDescription = "Filter List",
                    modifier = Modifier.size(24.dp, 24.dp),
                    tint = colors.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Box() {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(Plants) { plant ->
                        PlantCard(plant = plant)
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun DefaultPreview2() {
    MyTheme {
        Home()
    }
}

@Preview(widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun DefaultDarkPreview2() {
    MyTheme(darkTheme = true) {
        Home()
    }
}