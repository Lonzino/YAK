package com.example.myapplication.ui.theme.pages

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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.cafe24ssurroundfontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamillyList() {

    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Familly List", fontFamily = cafe24ssurroundfontFamily) },
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
                content = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        IconButton(onClick = { /* 네모난 버튼 1이 눌렸을 때의 동작 추가 */ }) {
                            Icon(Icons.Default.Face, contentDescription = null)
                        }

                        IconButton(onClick = { /* 네모난 버튼 2가 눌렸을 때의 동작 추가 */ }) {
                            Icon(Icons.Default.Home, contentDescription = null)
                        }

                        IconButton(onClick = { /* 네모난 버튼 3이 눌렸을 때의 동작 추가 */ }) {
                            Icon(Icons.Default.Favorite, contentDescription = null)
                        }

                        IconButton(onClick = { /* 네모난 버튼 4가 눌렸을 때의 동작 추가 */ }) {
                            Icon(Icons.Default.ThumbUp, contentDescription = null)
                        }
                    }

                }
            )
        }
    )
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
            Text(text = family.name, style = MaterialTheme.typography.bodyLarge, fontFamily = cafe24ssurroundfontFamily)
            Text(text = "오늘 남은 약: ${family.remainingMedicine}", style = MaterialTheme.typography.bodyLarge, fontFamily = cafe24ssurroundfontFamily  )
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Familly_listPreview() {
    MyApplicationTheme {
        FamillyList()
    }
}