package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.cafe24ssurround

@Immutable
data class Medicine(
    val name: String,
    val time: String,
    val frequency: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    var medicineList by remember { mutableStateOf<List<Medicine>>(emptyList()) }
    var isDialogOpen by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("삐약", fontFamily = cafe24ssurround, color = colorScheme.primaryContainer)
                },
                actions = {
                    IconButton(onClick = { /* 캘린더 아이콘 버튼이 눌렸을 때의 동작 추가 */ }) {
                        Icon(Icons.Default.DateRange, contentDescription = null)
                    }
                }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                    .padding(16.dp)
                    .border(5.dp, colorScheme.primaryContainer, shapes.large)
                    .aspectRatio(1f)
            ) {
                MedicineList(medicineList = medicineList,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isDialogOpen = true },
                shape = shapes.small,
                contentColor = colorScheme.onPrimary,
                modifier = Modifier
                    .size(48.dp)
                    .shadow(4.dp, shapes.small)
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        bottomBar = {
            BottomAppBar(
                contentColor = colorScheme.tertiary,
                containerColor = colorScheme.tertiary,
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
                                .background(colorScheme.primaryContainer, shapes.large)
                        ) {
                            Icon(Icons.Default.Home, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("Myprofile") },
                                modifier = Modifier
                                .size(60.dp)
                            .background(colorScheme.primaryContainer, shapes.large)

                        ) {
                            Icon(Icons.Default.Face, contentDescription = null)
                        }
                        IconButton(onClick = { showDialog = true },
                            modifier = Modifier
                                .size(60.dp)
                                .background(colorScheme.primaryContainer, shapes.large)
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null)
                        }
                        IconButton(onClick = { navController.navigate("famillyList") },
                            modifier = Modifier
                                .size(60.dp)
                                .background(colorScheme.primaryContainer, shapes.large)
                            ) {
                            Icon(Icons.Default.List, contentDescription = null)
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

    if (showDialog) {
        PopupMessage(
            title = "sorry",
            message = "아직 준비 중 입니다.",
            icon = Icons.Default.Warning,
            onDismiss = { showDialog = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopupMessage(title: String, message: String, icon: ImageVector, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        modifier = Modifier
            .size(300.dp)
            .padding(16.dp)
            .border(8.dp, colorScheme.onSurface, shapes.small)
            .shadow(4.dp, shapes.small)
            .background(colorScheme.surface)
        ,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = cafe24ssurround
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = cafe24ssurround
            )
        }
    }
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
                .background(colorScheme.surface)
                .border(5.dp, colorScheme.background, shapes.small)
        ) {
            // 약 이름 입력란
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("약 이름", fontFamily = cafe24ssurround) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // 투약 시간 입력란
            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("투약 시간", fontFamily = cafe24ssurround) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // 투약 횟수 입력란
            OutlinedTextField(
                value = frequency,
                onValueChange = { frequency = it },
                label = { Text("투약 횟수", fontFamily = cafe24ssurround) },
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
                Text("저장", fontFamily = cafe24ssurround)
            }
        }
    }
}

@Composable
fun MedicineList(medicineList: List<Medicine>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("약 목록", style = MaterialTheme.typography.bodyLarge, fontFamily = cafe24ssurround)

        // 저장된 약 정보를 리스트로 표시
        LazyColumn {
            items(medicineList) { medicine ->
                Text("약 이름: ${medicine.name}, 투약 시간: ${medicine.time}, 투약 횟수: ${medicine.frequency}")
            }
        }
    }
}

@Composable
fun AnotherComposable() {
    // 추가적인 컴포저블을 여기에 추가할 수 있습니다.
}
