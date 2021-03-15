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

import android.app.Activity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.WeTradeTheme
import com.example.androiddevchallenge3.R
import com.example.androiddevchallenge3.R.string

data class Position(
    val name: String,
    val description: String,
    val value: String,
    val trend: String,
    val graphId: Int
)

val positions = listOf(
    Position("ALK", "Alaska Air group, Inc.", "$7,918", "-0.54%", R.drawable.ic_home_alk),
    Position("BA", "Boeing Co.", "$1,293", "+4.18%", R.drawable.ic_home_ba),
    Position("DAL", "Delta airlines, Inc.", "$893.50", "-0.54%", R.drawable.ic_home_dal),
    Position("EXPE", "Expedia Group, Inc.", "$12,301", "+2.51%", R.drawable.ic_home_exp),
    Position("EDASY", "Airbus SE", "$12,301", "+1.38%", R.drawable.ic_home_eadsy),
    Position("SBLUE", "Jetblue Airways Corp.", "$8,512", "+1.56%", R.drawable.ic_home_jblu),
    Position("MAR", "Marriot International Inc.", "$512", "+2.75%", R.drawable.ic_home_mar),
    Position("CCL", "Carnival Corp.", "$5,481", "+0.14%", R.drawable.ic_home_ccl),
    Position("RCL", "Royal Caribbean Cruises", "$9,184", "+1.69%", R.drawable.ic_home_rcl),
    Position("TRVL", "Travelcity Inc.", "$7,918", "+3.23%", R.drawable.ic_home_trvl),
)

@ExperimentalMaterialApi
@Composable
fun HomeSheetScreen(expanded: Boolean) {

    val statusBarHeight by animateDpAsState(
        targetValue = if( (isSystemInDarkTheme() && !expanded) || !expanded) 32.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 50,
            easing = LinearOutSlowInEasing
        )
    )



    Surface(color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(statusBarHeight)
                    .fillMaxWidth()
                    .background(if (isSystemInDarkTheme()) Color.Transparent else Color.Gray)

            ) {

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        style = MaterialTheme.typography.body2,
                        text = stringResource(id = string.home_positions),
                        textAlign = Center,
                    )
                }

                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .background(MaterialTheme.colors.onSurface)
                )

                positions.forEach {
                    PositionView(it)
                    Divider(
                        modifier = Modifier
                            .height(1.dp)
                            .background(MaterialTheme.colors.onSurface)
                    )
                }
            }
        }
    }
}

@Composable
fun PositionView(position: Position) {
    val green = colorResource(id = R.color.custom_1)
    val red = colorResource(id = R.color.custom_2)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.padding(end = 32.dp)
        ) {
            Text(
                text = position.value,
                style = MaterialTheme.typography.body2
            )

            Text(
                text = position.trend,
                color = if (position.trend.startsWith("+")) green else red,
                style = MaterialTheme.typography.body2
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = position.name,
                style = MaterialTheme.typography.h3
            )

            Text(
                text = position.description,
                style = MaterialTheme.typography.body1
            )
        }

        Image(painter = painterResource(id = position.graphId), contentDescription = "graph")
    }
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun SheetScreenPreviewLight() {
    WeTradeTheme {
        HomeSheetScreen(true)
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun SheetScreenPreviewDark() {
    WeTradeTheme(darkTheme = true) {
        HomeSheetScreen(false)
    }
}
