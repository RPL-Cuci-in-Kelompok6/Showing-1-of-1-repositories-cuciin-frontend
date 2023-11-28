package com.example.cuciin_temp

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.cuciin_temp.ui.theme.Cuciin_tempTheme
import com.example.cuciin_temp.ui.theme.fontFamily

@Composable
fun Profile(NavController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFEAFCFF))
        .verticalScroll(rememberScrollState())
    ){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image( modifier = Modifier
                .padding(start = 20.dp)
                .width(20.dp)
                .height(14.49874.dp)
                .clickable { NavController.navigate("Dashboard") },
                painter = painterResource(id = R.drawable.panah),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Text( modifier = Modifier
                .width(200.dp)
                .height(32.dp),
                text = "Profile",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.size(70.dp))
        ProfileImage()

        Text(modifier = Modifier.fillMaxWidth(),
            text = "Stefani Floreska",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center
                )
        )
        Text(modifier = Modifier.fillMaxWidth(),
            text = "+91 8800850641",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF6E6F79),
                textAlign = TextAlign.Center
                )
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image( modifier = Modifier
                .padding(start = 20.dp)
                .width(20.dp)
                .height(19.49874.dp)
                .clickable { NavController.navigate("Dashboard") },
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Text( modifier = Modifier
                .width(150.dp)
                .height(32.dp),
                text = "Edit Profile",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }


        Spacer(modifier = Modifier.size(30.dp))
        Column(modifier = Modifier
            .padding(start = 40.dp)
            .width(318.dp)
            .height(53.57143.dp)
            .background(color = Color(0xFFF9F9F9), shape = RoundedCornerShape(size = 10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(20.dp)
                        .height(22.49874.dp)
                        .clickable { NavController.navigate("Dashboard") },
                    painter = painterResource(id = R.drawable.quest),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                Text(
                    modifier = Modifier
                        .width(100.dp)
                        .height(32.dp),
                    text = "Help",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Column(modifier = Modifier
            .padding(start = 40.dp)
            .width(318.dp)
            .height(53.57143.dp)
            .background(color = Color(0xFFF9F9F9), shape = RoundedCornerShape(size = 10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(20.dp)
                        .height(22.49874.dp)
                        .clickable { NavController.navigate("Dashboard") },
                    painter = painterResource(id = R.drawable.service),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                Text(
                    modifier = Modifier
                        .width(100.dp)
                        .height(32.dp),
                    text = "Platform Service",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Column(modifier = Modifier
            .padding(start = 40.dp)
            .width(318.dp)
            .height(53.57143.dp)
            .background(color = Color(0xFFF9F9F9), shape = RoundedCornerShape(size = 10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(20.dp)
                        .height(22.49874.dp)
                        .clickable { NavController.navigate("Dashboard") },
                    painter = painterResource(id = R.drawable.signout),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                Text(
                    modifier = Modifier
                        .width(100.dp)
                        .height(32.dp),
                    text = "Sign Out",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

        Row(modifier = Modifier
            .padding(top = 150.dp)
            .shadow(
                elevation = 30.dp,
                spotColor = Color(0x40435D6B),
                ambientColor = Color(0x40435D6B)
            )
            .shadow(
                elevation = 30.dp,
                spotColor = Color(0x40435D6B),
                ambientColor = Color(0x40435D6B)
            )
            .fillMaxWidth()
            .height(75.dp)
            .background(color = Color(0xFFCAE4E9), shape = RoundedCornerShape(size = 10.dp)),
            horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Image( modifier = Modifier
                    .width(40.dp)
                    .height(14.49874.dp)
                    .clickable { NavController.navigate("Dashboard") },
                    painter = painterResource(id = R.drawable.ic_round_dashboard),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = "Home",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF667C8A),

                        textAlign = TextAlign.Center,
                    )
                )
            }
            Column {
                Image( modifier = Modifier
                    .width(40.dp)
                    .height(17.49874.dp)
                    .clickable { NavController.navigate("Pesan") },
                    painter = painterResource(id = R.drawable.bytesize_heart),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = "Pesan",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF667C8A),

                        textAlign = TextAlign.Center,
                    )
                )
            }
            Column {
                Image( modifier = Modifier
                    .width(40.dp)
                    .height(14.49874.dp)
                    .clickable { NavController.navigate("History") },
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = "History",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF667C8A),

                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

    }
}

@Composable
fun ProfileImage(){
    val imageUrl = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if(imageUrl.value.isEmpty())
            R.drawable.ic_user
        else
            imageUrl.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent())
    {
            uri: Uri? ->
        uri?.let { imageUrl.value = it.toString() }
    }


    Column (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(size = 30.dp),
            modifier = Modifier
                .padding(8.dp)
                .size(130.dp)
                .width(106.dp)
                .height(106.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun profilePreview() {
    val navController = rememberNavController()
    Cuciin_tempTheme {
        Profile(NavController = navController)
    }
}
