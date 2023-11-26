package com.example.myapplication.ui.theme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.cafe24ssurroundfontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    var medicineList by remember { mutableStateOf<List<Medicine>>(emptyList()) }
    var isDialogOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("앱 페이지", fontFamily = cafe24ssurroundfontFamily)}
                ,
                actions = {
                    IconButton(onClick = { /* 캘린더 아이콘 버튼이 눌렸을 때의 동작 추가 */ }) {
                        Icon(Icons.Default.DateRange, contentDescription = null)
                    }
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                    .padding(16.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(16.dp)
                        .border(3.dp, Color.Green, MaterialTheme.shapes.medium)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.White)
                        .align(Alignment.Center)
                    ,content = {
                        FloatingActionButton(
                            onClick = { isDialogOpen = true },
                            modifier = Modifier
                                .size(48.dp)
                                .align(Alignment.Center)
                                .shadow(4.dp, MaterialTheme.shapes.medium)
                                .background(MaterialTheme.colorScheme.primary)
                            ) {
                            Icon(Icons.Default.Add, contentDescription = null)
                        }
                    }
                )
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
    // 약 정보를 입력하는 다이얼로그
    if (isDialogOpen) {
        AddMedicineDialog(
            onAddMedicine = { medicine ->
                // 입력된 약 정보를 저장
                medicineList = medicineList + medicine
            },
            onDismiss = { isDialogOpen = false }
        )
    }

    MedicineList(medicineList)
}

@Composable
fun AddMedicineDialog(onAddMedicine: (Medicine) -> Unit, onDismiss: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // 약 이름 입력란
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("약 이름") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // 투약 시간 입력란
            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("투약 시간") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // 투약 횟수 입력란
            OutlinedTextField(
                value = frequency,
                onValueChange = { frequency = it },
                label = { Text("투약 횟수") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // 저장 버튼
            Button(
                onClick = {
                    // 약 정보를 저장하고 다이얼로그 닫기
                    onAddMedicine(Medicine(name, time, frequency.toIntOrNull() ?: 0))
                    name = ""
                    time = ""
                    frequency = ""
                    // 다이얼로그 닫기
                    onDismiss()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("저장")
            }
        }
    }
}

@Composable
fun MedicineList(medicineList: List<Medicine>) {
    Column {
        Text("약 목록", style = MaterialTheme.typography.bodyLarge, fontFamily = cafe24ssurroundfontFamily)

        // 저장된 약 정보를 리스트로 표시
        LazyColumn {
            items(medicineList) { medicine ->
                Text("약 이름: ${medicine.name}, 투약 시간: ${medicine.time}, 투약 횟수: ${medicine.frequency}")
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    MyApplicationTheme {
        Home()
    }
}