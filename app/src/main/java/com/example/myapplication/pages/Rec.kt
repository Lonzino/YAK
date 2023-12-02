package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.cafe24ssurround

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Rec(navController: NavController) {
    var checkedState by remember { mutableStateOf(false) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("내 정보", fontFamily = cafe24ssurround, color = MaterialTheme.colorScheme.tertiary)
                },
                actions = {
                    IconButton(onClick = { /* 캘린더 아이콘 버튼이 눌렸을 때의 동작 추가 */
                    }
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                }
            )
        },
        content = {
            padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
             {
                Text(
                    text = "해당되는 내용에 체크하세요.",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp),
                    fontFamily = cafe24ssurround
                )


                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "피로 회복이 필요해요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround

                     )
                 }

                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "잠을 잘 못 자요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "공부에 집중 해야 해요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "컴퓨터, 휴대폰을 많이 봐요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "뼈, 관절이 아파요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "자주 어지러워요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "장이 안 좋아요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }

                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 10.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Checkbox(
                         checked = checkedState,
                         onCheckedChange = { checkedState = it },
                     )
                     Text(
                         text = "피부가 푸석푸석해요",
                         fontSize = 20.sp,
                         modifier = Modifier.padding(start = 8.dp),
                         fontFamily = cafe24ssurround
                     )
                 }



                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "영양제 추천 받기", fontSize = 20.sp,   fontFamily = cafe24ssurround)
                }

            }

        },
        bottomBar = {
            BottomAppBar(
                contentColor = MaterialTheme.colorScheme.tertiary,
                containerColor = MaterialTheme.colorScheme.tertiary,
                content = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        IconButton(onClick = { navController.navigate("Home") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    MaterialTheme.colorScheme.primaryContainer,
                                    MaterialTheme.shapes.large
                                )
                        ) {
                            Icon(Icons.Default.Home, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("Myprofile") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    MaterialTheme.colorScheme.primaryContainer,
                                    MaterialTheme.shapes.large
                                )

                        ) {
                            Icon(Icons.Default.Face, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("Rec") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    MaterialTheme.colorScheme.primaryContainer,
                                    MaterialTheme.shapes.large
                                )
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("famillyList") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    MaterialTheme.colorScheme.primaryContainer,
                                    MaterialTheme.shapes.large
                                )
                        ) {
                            Icon(Icons.Default.List, contentDescription = null)
                        }
                    }
                }
            )
        }
    )
}




@Preview
@Composable
fun PreviewRec() {
    Rec(navController = NavController(LocalContext.current))
}

