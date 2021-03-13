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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.WeTradeTheme
import com.example.androiddevchallenge3.R
import com.example.androiddevchallenge3.R.drawable
import com.example.androiddevchallenge3.R.string

@ExperimentalMaterialApi
@Composable
fun HomeContentScreen() {

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                contentAlignment = Alignment.BottomCenter
            ) {

                Row() {
                    Text(
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.body2,
                        text = stringResource(id = string.home_account),
                        textAlign = Center,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.body2,
                        text = stringResource(id = string.home_watchlist),
                        textAlign = Center,
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.body2,
                        text = stringResource(id = string.home_profile),
                        textAlign = Center,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(32.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(32.dp),
                    style = MaterialTheme.typography.subtitle1,
                    text = stringResource(id = string.home_balance),
                    textAlign = Center,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(48.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    modifier = Modifier,
                    style = MaterialTheme.typography.h1,
                    text = stringResource(id = string.home_balance_value),
                    textAlign = Center,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    modifier = Modifier,
                    style = MaterialTheme.typography.subtitle1,
                    color = colorResource(id = R.color.custom_1),
                    text = stringResource(id = string.home_balance_trend),
                    textAlign = Center,
                )
            }

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 46.dp, bottom = 16.dp)
                    .fillMaxWidth()
                    .height(46.dp),

                shape = RoundedCornerShape(50), // 50% percent

                onClick = {
                }
            ) {
                Text(
                    text = stringResource(id = string.home_transact),

                )
            }

            LazyRow() {
                item { HomeContentScreen(stringResource(id = string.home_week), true) }
                item { HomeContentScreen(stringResource(id = string.home_etfs)) }
                item { HomeContentScreen(stringResource(id = string.home_stocks)) }
                item { HomeContentScreen(stringResource(id = string.home_funds)) }
                item { HomeContentScreen(stringResource(id = string.home_other)) }
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                painter = painterResource(id = drawable.ic_home_illos),
                contentDescription = "graph",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun HomeContentScreen(text: String, showIcon: Boolean = false) {
    OutlinedButton(
        modifier = Modifier
            .height(40.dp)
            .padding(start = 8.dp),
        border = BorderStroke(1.dp, Color.White),
        shape = RoundedCornerShape(50), // 50% percent
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            backgroundColor = MaterialTheme.colors.background
        ),
        onClick = {
        }
    ) {
        Row() {
            Text(text = text)
            if (showIcon) {
                Icon(
                    imageVector = Icons.Default.ExpandMore,
                    contentDescription = "more"
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeContentScreenPreviewLight() {
    WeTradeTheme {
        HomeContentScreen()
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeContentScreenPreviewDark() {
    WeTradeTheme(darkTheme = true) {
        HomeContentScreen()
    }
}
