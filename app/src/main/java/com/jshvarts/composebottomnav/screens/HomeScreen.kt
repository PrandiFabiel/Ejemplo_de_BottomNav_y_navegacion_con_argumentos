package com.jshvarts.composebottomnav.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jshvarts.composebottomnav.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val id = 7

    Scaffold(

        topBar = {
            TopAppBar(){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Tickets",
                        style = MaterialTheme.typography.h5,
                    )
                    IconButton(onClick = {navController.navigate(Screen.About.withArgs(id.toString()))}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(20) {item ->
                    CoinsItem( onClick = {navController.navigate(Screen.About.withArgs(item.toString()))}, item)
                }
            }

        }
    }
}

@Composable
fun CoinsItem(
    onClick: () -> Unit,
    num: Int
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 7.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .clickable { onClick() }
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {

                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Prandi Fabiel $num")
            }
            Text(
                text = "18/2/21",
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Normal,
                letterSpacing = 3.sp,
            )
        }

    }
}