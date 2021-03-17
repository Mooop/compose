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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
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
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bg),
            contentDescription = "bg",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillWidth,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
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
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .paddingFromBaseline(32.dp, 40.dp)
                    .fillMaxWidth(),
                style = typography.subtitle1,
                color = Color(LocalContext.current.getColor(R.color.subtitle_1)),
            )

            Box(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
            ) {
                val context: Context = LocalContext.current
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                ) {
                    Text(
                        text = "Create account",
                        style = typography.button,
                    )
                }
            }

            val context: Context = LocalContext.current

            TextButton(
                onClick = {
                    Log.d("onClick", "click")
                    context.startActivity(Intent(context, LoginActivity::class.java))
                },
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
            ) {
                Text(
                    text = "Log in",
                    style = typography.button,
                    color = MaterialTheme.colors.secondaryVariant
                )
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
