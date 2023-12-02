package com.example.myapplication.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cafe24ssurround

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamillyList(navController: NavController) {

    val listState = rememberLazyListState()
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("우리 가좍", fontFamily = cafe24ssurround, color = MaterialTheme.colorScheme.tertiaryContainer) },
                actions = {
                    IconButton(
                        onClick = { },
                        modifier = Modifier.size(48.dp) // 아이콘 버튼 크기 조정
                    ) {
                        Icon(Icons.Default.Star, contentDescription = null)
                    }
                }
            )
        },
        content = {
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
            {
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // 리스트 아이템 생성
                    items(familyList) { family ->
                        FamillyListItem(family)
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                contentColor = MaterialTheme.colorScheme.tertiaryContainer,
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
                                .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.large)
                        ) {
                            Icon(Icons.Default.Home, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("Myprofile") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.large)

                        ) {
                            Icon(Icons.Default.Face, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("Rec") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.large)
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("famillyList") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.large)
                        ) {
                            Icon(Icons.Default.List, contentDescription = null)
                        }
                    }

                }
            )
        }
    )
    if (showDialog) {
        PopupMessage(
            title = "sorry",
            message = "아직 준비 중 입니다.",
            icon = Icons.Default.Warning,
            onDismiss = { showDialog = false }
        )
    }

}

@Composable
fun FamillyListItem(family: Family) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 이미지 아이콘
        Image(
            painter = painterResource(id = family.image),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(shape = MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.primary)
        )

        // 이름과 남은 약 횟수
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Text(text = family.name, style = MaterialTheme.typography.bodyLarge, fontFamily = cafe24ssurround)
            Text(text = "오늘 남은 약: ${family.remainingMedicine}", style = MaterialTheme.typography.bodyLarge, fontFamily = cafe24ssurround  )
        }
    }
}

@Composable
fun FamillyListBottomBarIcon(icon: ImageVector, label: String) {
    IconButton(
        onClick = { /* 아이콘을 클릭했을 때의 동작 추가 */ },
        modifier = Modifier.size(48.dp) // 아이콘 크기 조정
    ) {
        Icon(icon, contentDescription = null)
        Text(label, style = MaterialTheme.typography.bodyLarge)
    }
}

data class Family(val name: String, val remainingMedicine: Int, val image: Int)

val familyList = listOf(
    Family("가족1", 3, R.drawable.ic_launcher_foreground),
    Family("가족2", 5, R.drawable.ic_launcher_foreground),
    Family("가족3", 2, R.drawable.ic_launcher_foreground),
    // 추가적인 가족 정보를 필요에 따라 추가
)
