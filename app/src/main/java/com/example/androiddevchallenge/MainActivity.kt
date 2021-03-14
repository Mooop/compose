/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Welcome()
            }
        }
    }
}

// Start building your app here!
@Composable
fun Welcome() {
    Surface(color = MaterialTheme.colors.background) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bg),
            contentDescription = "bg",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 72.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_welcome_illos),
                contentDescription = "illos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(88.dp, 0.dp, 0.dp, 48.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "logo"
            )

            Text(
                text = "Beautiful home garden solutions",
                modifier = Modifier.height(32.dp),
                style = typography.subtitle1,
                color = Color(LocalContext.current.getColor(R.color.subtitle_1)),
            )

            Button(
                onClick = {
                    Log.d("onClick", "click")
                },
                shape = shapes.medium,
            ) {
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}
