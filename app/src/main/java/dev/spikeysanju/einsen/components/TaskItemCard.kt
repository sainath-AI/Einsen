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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.spikeysanju.einsen.model.task.Task
import dev.spikeysanju.einsen.ui.theme.Sailec
import dev.spikeysanju.einsen.ui.theme.einsenColors
import dev.spikeysanju.einsen.ui.theme.typography

/**
 * This component is used to show all the task item of this app.
 * @param task
 * @param onClick
 * @param onCheckboxChange
 */

@Composable
fun TaskItemCard(
    modifier: Modifier = Modifier,
    task: Task,
    onClick: () -> Unit,
    onCheckboxChange: (Boolean) -> Unit
) {

    Spacer(modifier = modifier.height(12.dp))
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        // checkbox state
        val status = remember { mutableStateOf(task.isCompleted) }

        /**
         * Checkbox
         */
        EisenCheckBox(
            value = status.value,
            onValueChanged = {
                status.value = it
                onCheckboxChange(status.value)
            }
        )

        Spacer(modifier = modifier.width(12.dp))

        /**
         * Emoji + (title + category)
         */
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = shapes.large)
                .background(einsenColors.card)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            /**
             * Emoji Text View
             */
            EmojiTextView(emoji = task.emoji)
            Spacer(modifier = modifier.width(12.dp))

            /**
             * Title + category
             */
            Column(
                modifier = modifier
                    .align(Alignment.CenterVertically),
            ) {
                Text(
                    text = task.title,
                    style = when (task.isCompleted) {
                        true -> TextStyle(
                            textDecoration = TextDecoration.LineThrough,
                            fontSize = 16.sp,
                            fontFamily = Sailec,
                            fontWeight = FontWeight.SemiBold
                        )
                        false -> TextStyle(
                            fontSize = 16.sp,
                            fontFamily = Sailec,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    color = einsenColors.black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = modifier.height(12.dp))

                Text(
                    text = task.category,
                    style = when (task.isCompleted) {
                        true -> TextStyle(
                            textDecoration = TextDecoration.LineThrough,
                            fontSize = 12.sp,
                            fontFamily = Sailec,
                            fontWeight = FontWeight.Normal
                        )
                        false -> typography.caption
                    },
                    color = einsenColors.black.copy(.7f)
                )
            }
        }
    }
}

/**
 * This component helps to show Emoji with Rounded background.
 * @param emoji
 */
@Composable
fun EmojiTextView(modifier: Modifier = Modifier, emoji: String) {
    Box(
        modifier = modifier
            .size(80.dp)
            .padding(12.dp)
            .clip(CircleShape)
            .clickable { }
            .background(einsenColors.bg)
    ) {
        Text(
            text = emoji,
            color = einsenColors.black,
            style = typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

/**
 * This customer slider component helps to show the slider with step indicator.
 * @param value
 * @param onValueChanged
 */
@Composable
fun EisenCheckBox(value: Boolean, onValueChanged: (Boolean) -> Unit) {
    Checkbox(
        checked = value,
        onCheckedChange = {
            onValueChanged(it)
        },
        colors = CheckboxDefaults.colors(
            colors.onPrimary,
            colors.onPrimary.copy(0.3F)
        )
    )
}
