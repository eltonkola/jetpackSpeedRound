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
package com.example.androiddevchallenge.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.ui.theme.WeTradeTheme
import com.example.androiddevchallenge3.R.color
import com.example.androiddevchallenge3.R.drawable
import com.example.androiddevchallenge3.R.string

@Composable
fun WelcomeScreen(onLogin: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = drawable.ic_welcome_bg),
                contentDescription = "background",
                contentScale = ContentScale.FillBounds
            )

            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {
                val (logo, actions) = createRefs()

                Image(
                    modifier = Modifier
                        .constrainAs(logo) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        },
                    painter = painterResource(id = drawable.ic_logo),
                    contentDescription = "logo"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(start = 16.dp, end = 16.dp)
                        .constrainAs(actions) {
                            bottom.linkTo(parent.bottom, 32.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {

                    val context = LocalContext.current

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),

                        shape = RoundedCornerShape(50), // 50% percent

                        onClick = {
                            Toast.makeText(
                                context,
                                "TODO - This is not yet implemented",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Text(text = stringResource(id = string.welcome_get_started))
                    }

                    Box(modifier = Modifier.width(16.dp))

                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),

                        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                        shape = RoundedCornerShape(50), // 50% percent
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colors.primary,
                            backgroundColor = colorResource(id = color.background_light)

                        ),

                        onClick = {
                            onLogin()
                        }
                    ) {
                        Text(text = stringResource(id = string.welcome_login))
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreviewLight() {
    WeTradeTheme {
        WelcomeScreen {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreviewDark() {
    WeTradeTheme(darkTheme = true) {
        WelcomeScreen {}
    }
}
