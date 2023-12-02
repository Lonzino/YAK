   package com.example.myapplication.pages

   import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cafe24ssurround


   @OptIn(ExperimentalMaterial3Api::class)
   @Composable
   fun Myprofile( navController: NavController) {
      var showDialog by remember { mutableStateOf(false) }

      Scaffold(
         topBar = {
            TopAppBar(
               title = {
                  Text("내 정보", fontFamily = cafe24ssurround, color = MaterialTheme.colorScheme.tertiaryContainer)
               },
               actions = {
                  IconButton(onClick = { /* 캘린더 아이콘 버튼이 눌렸을 때의 동작 추가 */
                  },
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.tertiary, MaterialTheme.shapes.large)

                  ) {
                     Icon(Icons.Default.Edit, contentDescription = null)
                  }
               }
            )
         },
         content = {padding ->

            LazyColumn(
               modifier = Modifier
                  .fillMaxSize()
                  .padding(padding)
            ) {
               item {
                  // Profile picture and name
                  ProfileHeader()
               }

               item {
                  // Summary
                  ProfileSummary()
               }

               item {
                  // Photo gallery
                  PhotoGallery()
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
            title = "HMMMM",
            message = "아직 준비 중 입니다.",
            icon = Icons.Default.Done,
            onDismiss = { showDialog = false }
         )
      }

   }
   @Composable
   fun ProfileHeader() {
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ) {

         Spacer(modifier = Modifier.height(56.dp))


            // Background color for the lower half of the circle
            Box(
               modifier = Modifier
                  .fillMaxSize()
                  .background(MaterialTheme.colorScheme.tertiary)
            )
            Image(
               painter = painterResource(id = R.drawable.side_bbiyo),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                  .size(200.dp) // 조절 가능한 크기
                  .clip(CircleShape)
                  .background(MaterialTheme.colorScheme.primary)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
            ) {
               Text(
                  text = "김삐약",
                  style = MaterialTheme.typography.headlineLarge,
                  modifier = Modifier
                     .padding(8.dp),
                    fontFamily = cafe24ssurround,


               )
            }

      }
   }
      @Composable
      fun ProfileSummary() {
         Text(
            text = "Vitamin B",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
               .wrapContentHeight(),
            fontFamily = cafe24ssurround,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
         )
         Text(
            text = "~ 2021.09.30",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
               .wrapContentHeight(),
            fontFamily = cafe24ssurround,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
         )
      }

      @Composable
      fun PhotoGallery() {
         // Your photo gallery code goes here
      }

   @Preview
   @Composable
   fun Myprofilpreview() {
      Myprofile(navController = NavController(LocalContext.current))
   }

