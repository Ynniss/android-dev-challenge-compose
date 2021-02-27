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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.cats
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.helpers.CatHelper.getCatImage
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                AppNavigation()
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
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") {
            HomeScreen(navController, cats)
        }
        composable("CatDetails") {
            CatDetailsScreen()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyTheme {
        AppNavigation()
    }
}

@Composable
fun HomeScreen(navController: NavController, cats: List<Cat>) {
    Column {
        MyTopAppBar()
        CatList(
            navController,
            cats,
            Modifier
                .weight(1f)
        )
    }
}

@Composable
fun CatDetailsScreen() {
    Column {
        MyTopAppBar()
        Text(text = "Cat details")
    }
}


@Composable
fun CatCard(navController: NavController, cat: Cat) {
    Card(
        modifier = Modifier
            .border(1.dp, Color.Transparent)
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = { navController.navigate("CatDetails") }),
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
                    .size(150.dp)
                    .border(8.dp, MaterialTheme.colors.primaryVariant, CircleShape)
                    .fillMaxWidth()
            )

            Text(
                text = cat.name,
                modifier = Modifier
                    .padding(48.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun CatList(navController: NavController, cats: List<Cat>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = cats) { index, cat ->
            CatCard(navController, cat)
        }
    }
}
