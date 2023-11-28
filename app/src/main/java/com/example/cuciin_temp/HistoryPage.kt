package com.example.cuciin_temp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HistoryPage(NavController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "History",
                        textAlign = TextAlign.Center,

                        style = TextStyle(
                            fontSize = 22.sp,
//                            fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { NavController.navigate("Dashboard") }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },

                )
        }
    ) { contentPadding ->
        // Screen content
        Column (modifier = Modifier.padding(contentPadding)){
            Spacer(modifier = Modifier.height(20.dp))
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row (
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                ){
                    Box (
                        modifier = Modifier
                            .width(71.dp)
                            .height(71.dp)
                            .background(
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Fuzzy Laundry",
                            style = TextStyle(
                                fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Jl. Soekarno-Hatta No. 36 - Malang",
                            style = TextStyle(
                                fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row{
                            Image(
                                painter = painterResource(id = R.drawable.map_pin),
                                contentDescription = "image description",
                                modifier = Modifier
                                    .width(16.dp)
                                    .height(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            ClickableText(
                                text = AnnotatedString("Gmaps"),
                                style = TextStyle(
                                    fontSize = 12.sp,
//                                    fontFamily = FontFamily(Font(R.font.inter)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF248CC6),
                                    textDecoration = TextDecoration.Underline,
                                ),
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.width(100.dp))

                            Button(
                                onClick = {NavController.navigate("Layanan") },
                                modifier = Modifier
                                    .height(22.dp)
                                    .width(96.dp),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF3D4EB0), // Change the background color here
                                    contentColor = Color.White // Change the text color here
                                )
                            ) {
                                Text(
                                    text = "Pesan Lagi",
                                    style = TextStyle(
                                        fontSize = 12.sp,
//                                        fontFamily = FontFamily(Font(R.font.poppins)),
                                        fontWeight = FontWeight(500),
                                    )
                                )
                            }
                        }
                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row (
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                ){
                    Box (
                        modifier = Modifier
                            .width(71.dp)
                            .height(71.dp)
                            .background(
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Fuzzy Laundry",
                            style = TextStyle(
                                fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Jl. Soekarno-Hatta No. 36 - Malang",
                            style = TextStyle(
                                fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row{
                            Image(
                                painter = painterResource(id = R.drawable.map_pin),
                                contentDescription = "image description",
                                modifier = Modifier
                                    .width(16.dp)
                                    .height(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            ClickableText(
                                text = AnnotatedString("Gmaps"),
                                style = TextStyle(
                                    fontSize = 12.sp,
//                                    fontFamily = FontFamily(Font(R.font.inter)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF248CC6),
                                    textDecoration = TextDecoration.Underline,
                                ),
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.width(100.dp))

                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .height(22.dp)
                                    .width(96.dp),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF3D4EB0), // Change the background color here
                                    contentColor = Color.White // Change the text color here
                                )
                            ) {
                                Text(
                                    text = "Pesan Lagi",
                                    style = TextStyle(
                                        fontSize = 12.sp,
//                                        fontFamily = FontFamily(Font(R.font.poppins)),
                                        fontWeight = FontWeight(500),
                                    )
                                )
                            }
                        }
                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row (
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                ){
                    Box (
                        modifier = Modifier
                            .width(71.dp)
                            .height(71.dp)
                            .background(
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Fuzzy Laundry",
                            style = TextStyle(
                                fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Jl. Soekarno-Hatta No. 36 - Malang",
                            style = TextStyle(
                                fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row{
                            Image(
                                painter = painterResource(id = R.drawable.map_pin),
                                contentDescription = "image description",
                                modifier = Modifier
                                    .width(16.dp)
                                    .height(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            ClickableText(
                                text = AnnotatedString("Gmaps"),
                                style = TextStyle(
                                    fontSize = 12.sp,
//                                    fontFamily = FontFamily(Font(R.font.inter)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF248CC6),
                                    textDecoration = TextDecoration.Underline,
                                ),
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.width(100.dp))

                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .height(22.dp)
                                    .width(96.dp),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF3D4EB0), // Change the background color here
                                    contentColor = Color.White // Change the text color here
                                )
                            ) {
                                Text(
                                    text = "Pesan Lagi",
                                    style = TextStyle(
                                        fontSize = 12.sp,
//                                        fontFamily = FontFamily(Font(R.font.poppins)),
                                        fontWeight = FontWeight(500),
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

