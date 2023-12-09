package com.example.cuciin_temp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.cuciin_temp.ui.theme.Cuciin_tempTheme
import com.example.cuciin_temp.ui.theme.fontFamily


@Composable
fun DaftarLayanan(NavController: NavHostController) {

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
                .clickable { NavController.navigate("Type")},
                painter = painterResource(id = R.drawable.panah),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Text( modifier = Modifier
                .width(200.dp)
                .height(32.dp),
                text = "DAFTAR LAYANAN",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.size(40.dp))
        Text(modifier = Modifier
            .fillMaxWidth()
            .height(33.dp),
            text = "LAUNDRY BUDDY",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.size(20.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(520.dp)
        ) {
            MyCardList()
        }
        Column(modifier = Modifier
            .padding(top = 50.dp, start = 40.dp)
            .width(306.dp)
            .height(50.dp)
            .background(color = Color(0xFF3D4EB0), shape = RoundedCornerShape(size = 5.08002.dp))
            .clickable { NavController.navigate("Booking") },

            ) {
            Text(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize(),
                text = "Confirm",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun MyCardList() {
    val cardData = remember { generateFakeCards() }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(26.dp)
    ) {
        cardData.forEachIndexed { index, card ->
            item(span = { GridItemSpan(1) }) {
                MyCard(
                    number = card.first,
                    kilos = card.second
                )
            }
        }
    }
}

@Composable
fun MyCard(
    number: String,
    kilos: String

) {
    var isBackgroundChanged by remember { mutableStateOf(false) }
    val backgroundColor = if (isBackgroundChanged) {
        Color.Cyan // Change this to the color you want when clicked
    } else {
        Color.LightGray // Default color
    }
    Card(modifier = Modifier
        .width(107.13878.dp)
        .height(112.dp)
        .clickable { isBackgroundChanged = !isBackgroundChanged }
        .background(
            color = Color(0xFFFFFFFF),
            shape = RoundedCornerShape(size = 5.08002.dp)
        ),
            colors = CardDefaults.cardColors(
            containerColor = backgroundColor,)
        ) {
        Image( modifier = Modifier
            .padding(start = 38.dp, top = 10.dp)
            .width(29.03123.dp)
            .height(33.23892.dp),
            painter = painterResource(id = R.drawable.washing_machine),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
            text = number,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
            text = kilos,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
    }
}

private fun generateFakeCards(): List<Pair<String, String>> {
    return MutableList(20) { index ->
        val cardNumber = index + 1
        "$cardNumber" to "$cardNumber"
    }
}


@Preview(showBackground = true)
@Composable
fun LayananPreview() {
    val navController = rememberNavController()
    Cuciin_tempTheme {
        DaftarLayanan(NavController = navController)
    }
}

