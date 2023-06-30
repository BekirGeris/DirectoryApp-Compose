package com.example.directory_compose.ui.view.page

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.directory_compose.model.User
import com.example.directory_compose.viewmodel.UserSaveViewModel
import com.example.directory_compose.viewmodelfactory.UserSaveFactory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserSavePage() {
    val context = LocalContext.current
    val viewModel: UserSaveViewModel = viewModel(
        factory = UserSaveFactory(context.applicationContext as Application)
    )
    val userName = remember { mutableStateOf("") }
    val userTel = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "User Save") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = userName.value,
                    onValueChange = { userName.value = it },
                    label = { Text(text = "User Name") })
                TextField(
                    value = userTel.value,
                    onValueChange = { userTel.value = it },
                    label = { Text(text = "User Tel") })
                Button(
                    onClick = {
                        val name = userName.value
                        val tel = userTel.value
                        viewModel.saveUser(User(0, name, tel, ""))
                        localFocusManager.clearFocus()
                    },
                    modifier = Modifier.size(250.dp, 50.dp)
                ) {
                    Text(text = "SAVE")
                }
            }
        }
    )
}