package com.example.androiddevchallenge

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Login()
            }
        }
    }
}

@Composable
fun Login() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        ) {
            Text(
                text = "Log in with email",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 184.dp),
                style = typography.h1,
                color = MaterialTheme.colors.onPrimary,
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = email,
                onValueChange = {
                    Log.d(LoginActivity::class.simpleName, "Email address:$it")
                    email = it
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
                        text = "Email address",
                        style = typography.body1,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    textColor = colors.onPrimary
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = {
                    Log.d(LoginActivity::class.simpleName, "Password:$it")
                    password = it
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
                        text = "Password (8 + characters) ",
                        style = typography.body1,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    textColor = colors.onPrimary
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                style = typography.body2,
                color = MaterialTheme.colors.onPrimary,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            ) {
                Text(
                    text = "Log in",
                    style = typography.button,
                )
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        Login()
    }
}

@Preview(widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun DefaultDarkPreview() {
    MyTheme(darkTheme = true) {
        Login()
    }
}

