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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.androiddevchallenge3.R

@Composable
fun WeTradeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) {
        darkColors(
            primary = colorResource(id = R.color.primary_dark),
            onPrimary = colorResource(id = R.color.on_primary_dark),
            background = colorResource(id = R.color.background_dark),
            surface = colorResource(id = R.color.surface_dark),
            onBackground = colorResource(id = R.color.on_background_dark),
            onSurface = colorResource(id = R.color.on_surface_dark),
        )
    } else {
        lightColors(
            primary = colorResource(id = R.color.primary_light),
            onPrimary = colorResource(id = R.color.on_primary_light),
            background = colorResource(id = R.color.background_light),
            surface = colorResource(id = R.color.surface_light),
            onBackground = colorResource(id = R.color.on_background_light),
            onSurface = colorResource(id = R.color.on_surface_light),
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
