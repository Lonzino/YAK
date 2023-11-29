package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.ContentAlpha
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
               Text("내 정보", fontFamily = cafe24ssurround)
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
      content = {padding ->

         MyProfileContent(
            selectedImageUri = "selectedImageUri",
            onImageSelected = { uri -> "selectedImageUri"},
            modifier = Modifier.padding(padding)
               .fillMaxSize()
               .padding(16.dp)
               .clip(MaterialTheme.shapes.medium)
               .background(MaterialTheme.colorScheme.surface)

         )


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
                  IconButton(onClick = { showDialog = true },
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
fun MyProfileContent(selectedImageUri: String?, onImageSelected: (String) -> Unit, modifier: Modifier = Modifier) {
   Column(
      modifier = modifier
         .fillMaxSize()
         .padding(16.dp)

   ) {
      // Profile Image
      ProfileImage(
         selectedImageUri = selectedImageUri,
         onImageSelected = onImageSelected,
         modifier = Modifier
            .size(120.dp)
            .padding(bottom = 16.dp)
      )

      // Name
      Text(
         text = "John Doe",
         style = MaterialTheme.typography.bodyMedium,
         fontWeight = FontWeight.Bold,
         modifier = Modifier.padding(bottom = 8.dp)
      )

      // Age
      Text(
         text = "Age: 30",
         style = MaterialTheme.typography.bodyMedium,
         color = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium)
      )
   }
}

@Composable
fun ProfileImage(selectedImageUri: String?, onImageSelected: (String) -> Unit, modifier: Modifier = Modifier) {
   val context = LocalContext.current

   Box(
      modifier = modifier
         .clip(CircleShape)
         .background(MaterialTheme.colorScheme.primary)
         .border(2.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)
   ) {
      if (selectedImageUri != null) {
         // Display the selected image
         Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
               .fillMaxSize()
               .clickable {
                  // Handle image click for selected image
                  // You can open a larger preview or perform other actions here
               }
         )
      } else {
         // Display a default icon with the option to select an image
         Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
               .fillMaxSize()
               .clickable {
                  // Handle image click to select a new image
                  // You can open a file picker or gallery intent here
                  // After selecting an image, call onImageSelected with the new URI
                  // Example: onImageSelected(newImageUri)
               }
         )
      }
   }
}
