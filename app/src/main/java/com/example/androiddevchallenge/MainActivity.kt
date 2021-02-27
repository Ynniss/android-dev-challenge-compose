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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.cats
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.helpers.CatHelper.getCatImage
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent(cats)
            }
        }
    }
}


@Composable
fun MyTopAppBar() {
    TopAppBar(
        elevation = 12.dp,
        title = { Text(text = "Catdopt") },
        navigationIcon = {
            Image(
                painter = painterResource(R.drawable.catdopt),
                contentDescription = "app Icon",
                modifier = Modifier.padding(10.dp)
            )
        }
    )
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyTheme {
        Column {
            MyTopAppBar()
            content()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent(cats)
    }
}

@Composable
fun MyScreenContent(cats: List<Cat>) {
    Column {
        CatList(
            cats,
            Modifier
                .weight(1f)
        )
    }
}


@Composable
fun CatCard(cat: Cat) {
    Card(
        modifier = Modifier
            .border(1.dp, Color.Transparent)
            .padding(16.dp)
            .fillMaxWidth(),
        //.clickable(onClick = ),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = getCatImage(cat.name)),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
                    .border(8.dp, MaterialTheme.colors.primaryVariant, CircleShape).
                    fillMaxWidth()
            )

            Text(
                text = cat.name,
                modifier = Modifier
                    .padding(24.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun CatList(cats: List<Cat>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = cats) { index, cat ->
            CatCard(cat)
        }
    }
}
