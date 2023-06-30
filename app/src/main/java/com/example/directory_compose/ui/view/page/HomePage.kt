package com.example.directory_compose.ui.view.page

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.directory_compose.R
import com.example.directory_compose.viewmodel.HomeViewModel
import com.example.directory_compose.viewmodelfactory.HomePageFactory
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(navController: NavController) {
    val context = LocalContext.current
    val viewModel: HomeViewModel = viewModel(
        factory = HomePageFactory(context.applicationContext as Application)
    )
    var isSearch = remember { mutableStateOf(false) }
    var searchText = remember { mutableStateOf("") }
    var userList = viewModel.userList.observeAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getAllUsers()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearch.value) {
                        TextField(
                            value = searchText.value,
                            onValueChange = {
                                searchText.value = it
                                viewModel.searchUser(it)
                            },
                            label = { Text(text = "Search") },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                textColor = Color.White,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White,
                                unfocusedIndicatorColor = Color.White
                            )
                        )
                    } else {
                        Text(text = "Directory")
                    }
                },
                actions = {
                    if (isSearch.value) {
                        IconButton(
                            onClick = {
                                isSearch.value = false
                                searchText.value = ""
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_close_24),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    } else {
                        IconButton(
                            onClick = {
                                isSearch.value = true
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_search_24),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        content = {
            LazyColumn(modifier = Modifier
                .padding(top = 66.dp)
                .fillMaxSize()) {
                items(
                    count = userList.value?.count() ?: 0,
                    itemContent = {
                        val user = userList.value!![it]

                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            )
                        ) {
                            Row(
                                modifier = Modifier.clickable {
                                    val userJson = Gson().toJson(user)
                                    navController.navigate("detail_page/${userJson}")
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "${user.userName} - ${user.userTel}")
                                    IconButton(
                                        onClick = {
                                            viewModel.deleteUser(user)
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_delete_24),
                                            contentDescription = "",
                                            tint = MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("save_page")
                },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}