package com.example.cuciin_temp

import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cuciin_temp.model.MitraX
import com.example.cuciin_temp.viewModel.MitraViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MitraPage(NavController: NavHostController) {
    val mitraViewModel = viewModel<MitraViewModel>()
//    val vm = viewModel<MainViewModel>()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Daftar Layanan",
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

            LazyColumn {

                items(mitraViewModel.MitraXListResponse) { item ->
                    MitraItem(item, NavController)
                }
            }
            mitraViewModel.getMitraX()



        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MitraItem(mitraX : MitraX, NavController: NavHostController) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { NavController.navigate("Layanan") }

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
                    text = mitraX.nama,
                    style = TextStyle(
                        fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = mitraX.telepon,
                    style = TextStyle(
                        fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = mitraX.email,
                    style = TextStyle(
                        fontSize = 13.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row{
                    Image(
                        painter = painterResource(id = R.drawable.map_pin),
                        contentDescription = "image description",
                        modifier = Modifier
                            .width(9.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    ClickableText(
                        text = AnnotatedString("Gmaps"),
                        style = TextStyle(
                            fontSize = 9.sp,
//                                    fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF248CC6),
                            textDecoration = TextDecoration.Underline,
                        ),
                        onClick = {}
                    )

                }
            }
        }
    }

}
