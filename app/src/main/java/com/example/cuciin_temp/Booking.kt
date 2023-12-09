package com.example.cuciin_temp

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun Booking(NavController: NavHostController) {
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
                .clickable { NavController.navigate("Layanan") },
                painter = painterResource(id = R.drawable.panah),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Text( modifier = Modifier
                .width(200.dp)
                .height(32.dp),
                text = "Booking",
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
            .fillMaxWidth(),
            text = "Mesin Cuci 11",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.size(10.dp))
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Available",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6E6F79),
                )
            )
            Box(modifier = Modifier
                .padding(0.dp)
                .width(1.dp)
                .height(20.04796.dp)
                .background(color = Color(0xFF6E6F79))
            )
            Text(
                text = "Fuzzy Laundry",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6E6F79),
                )
            )
        }
        Spacer(modifier = Modifier.size(40.dp))
        Text(modifier = Modifier
            .padding(start = 30.dp),
            text = "Choose wash type",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),

                )
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column (modifier = Modifier
            .width(400.dp)
            .height(450.dp)
        ){
            Payment()
        }

        Column(modifier = Modifier
            .padding(top = 50.dp, start = 40.dp)
            .width(306.dp)
            .height(50.dp)
            .background(color = Color(0xFF3D4EB0), shape = RoundedCornerShape(size = 5.08002.dp))
            .clickable { NavController.navigate("Status") },

            ) {
            Text(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize(),
                text = "Booking",
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
fun MyPay(
    payment: String,
){
    var isBackgroundChanged by remember { mutableStateOf(false) }
    val backgroundColor = if (isBackgroundChanged) {
        Color(0xFF3D4EB0) // Change this to the color you want when selected
    } else {
        Color(0xFF47B7DD) // Default color
    }
    Spacer(modifier = Modifier.size(30.dp))
    Column(modifier = Modifier
        .width(365.dp)
        .height(54.dp)
        .padding(start = 30.dp)
        .background(color = backgroundColor, shape = RoundedCornerShape(size = 8.dp))
        .clickable { isBackgroundChanged = !isBackgroundChanged },
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image( modifier = Modifier
                .padding(top = 15.dp, start = 20.dp)
                .width(20.dp)
                .height(14.49874.dp),
                painter = painterResource(id = R.drawable.setrika),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Text(
                modifier = Modifier
                    .padding(top = 15.dp),
                text = payment,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )
        }
    }
}

val Payment = listOf("Cash", "Qris")

@Composable
fun Payment() {
    Column {
        for (i in Payment.indices) {
            MyPay(Payment[i])
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between columns
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingPreview() {
    val navController = rememberNavController()
    Cuciin_tempTheme {
        Booking(NavController = navController)
    }
}