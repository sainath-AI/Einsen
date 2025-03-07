/*
 *
 *  * Copyright 2021 Spikey Sanju
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

package dev.spikeysanju.einsen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.spikeysanju.einsen.ui.theme.einsenColors
import dev.spikeysanju.einsen.ui.theme.typography
/**
 * This component helps to perform call to action of this app.
 * @param title
 * @param onclick
 */
@Composable
fun PrimaryButton(modifier: Modifier = Modifier, title: String, onclick: () -> Unit) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(RoundedCornerShape(60.dp))
            .padding(start = 20.dp, end = 20.dp),
        onClick = { onclick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = einsenColors.button,
            contentColor = einsenColors.white
        ),
    ) {
        Text(
            text = title,
            style = typography.subtitle2,
            textAlign = TextAlign.Center,
            color = einsenColors.white
        )
    }
}

/**
 * This component helps to perform call to action of this app especially for Task details screen.
 * @param title
 * @param icon
 * @param onclick
 * @param color
 */
@Composable
fun PrimaryButtonWithIcon(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter,
    onclick: () -> Unit,
    color: Color
) {
    Button(
        onClick = { onclick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = Color.White
        )
    ) {
        Icon(
            painter = icon,
            contentDescription = title,
            tint = Color.White
        )

        Spacer(modifier = modifier.width(12.dp))

        Text(
            text = title,
            style = typography.subtitle2,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}
