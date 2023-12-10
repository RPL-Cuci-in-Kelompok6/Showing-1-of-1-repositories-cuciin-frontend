package com.example.cuciin_temp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QueryBuilder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.cuciin_temp.model.GetOrderRequest
import com.example.cuciin_temp.model.GetOrderResponse
import com.example.cuciin_temp.model.Pesanan
import com.example.cuciin_temp.model.ServicesResponses
import com.example.cuciin_temp.network.RetrofitAPI
import com.example.cuciin_temp.ui.theme.fontFamily
import com.example.cuciin_temp.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DashboardPage(NavController: NavHostController, mainViewModel: MainViewModel) {
    var name by remember { mutableStateOf(mainViewModel.customerEmail) }
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(25.dp, 15.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Box(modifier = Modifier.weight(3F)){
                    Column {
                        Text(
                            text = "Selamat Datang,",
                            style = TextStyle(
                                fontSize = 24.sp,
                                //                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(300),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = name,
                            style = TextStyle(
                                fontSize = 24.sp,
//                              fontFamily = fontFamily
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                }
                Box(modifier = Modifier.weight(1F)){
                    Image(
                        painter = painterResource(id = R.drawable.people1),
                        contentDescription = "image description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(57.dp)
                            .width(57.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterEnd)
                            .clickable { NavController.navigate("Profile") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(20.dp, 4.dp)

            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(1.dp),
                ) {
                    Text(
                        text = "Pesanan Aktif",
                        style = TextStyle(
                            fontSize = 24.sp,
//                            fontFamily = FontFamily(Font(R.font.fjalla one)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )

                    postGetOrder(mainViewModel, NavController)

                    Spacer(modifier = Modifier.height(10.dp))
                    if (mainViewModel.listOrder != null){
                        LazyColumn(
                            modifier = Modifier.height(200.dp)
                        ){
                            items(mainViewModel.listOrder){ order ->
                                ElevatedCard(
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 6.dp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White,
                                    ),
                                    onClick = {
                                        mainViewModel.selectedPesanan = order
                                        NavController.navigate("Status")
                                    },


                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp, 5.dp)
                                    ) {
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.mesin),
                                            contentDescription = "image description",
                                            contentScale = ContentScale.None,
                                            modifier = Modifier
                                                .width(41.dp)
                                                .height(50.dp)
                                        )
                                        Spacer(modifier = Modifier.width(15.dp))
                                        Column {
                                            Text(
                                                text = "Pesanan ID: " + order.id,
                                                style = TextStyle(
                                                    fontSize = 17.sp,
//                                            fontFamily = FontFamily(Font(R.font.fjalla one)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFF000000),
                                                )
                                            )
                                            Text(
                                                text = "status: " + order.status,
                                                style = TextStyle(
                                                    fontSize = 17.sp,
//                                            fontFamily = FontFamily(Font(R.font.roboto)),
                                                    fontWeight = FontWeight(300),
                                                    color = Color(0xFF38822C),
                                                )
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                            }

                        }
                    }else{
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "belum ada order yang terbuat",
                                style = TextStyle(
                                    fontSize = 17.sp,
//                                            fontFamily = FontFamily(Font(R.font.fjalla one)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "PESAN LAGI",
                modifier = Modifier.padding(20.dp,0.dp,0.dp,0.dp),
                style = TextStyle(
                    fontSize = 24.sp,
//                    fontFamily = FontFamily(Font(R.font.fjalla one)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(20.dp, 4.dp)

            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { NavController.navigate("Pesan") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.toko1),
                        contentDescription = "image description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(shape = RoundedCornerShape(10.dp))


                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.shopping_bag),
                            contentDescription = "image description",
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                                .align(Alignment.TopEnd)
                        )
                        Column (
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ){
                            Text(
                                text = "Laundry Buddy",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 24.sp,
//                                fontFamily = FontFamily(Font(R.font.nunito)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF2B2B43),
                                    letterSpacing = 0.1.sp,
                                )
                            )
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(Icons.Outlined.QueryBuilder, contentDescription = null)
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "50-70 min",

                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 16.sp,
//                                        fontFamily = FontFamily(Font(R.font.nunito)),
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF83859C),
                                    )
                                )

                                Spacer(modifier = Modifier.width(3.dp))

                                Box(modifier = Modifier
                                    .padding(1.dp)
                                    .width(3.dp)
                                    .height(3.dp)
                                    .background(color = Color(0xFF4E60FF)))

                                Spacer(modifier = Modifier.width(3.dp))

                                Text(
                                    text = "Rp.15.000",

                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 16.sp,
//                                        fontFamily = FontFamily(Font(R.font.nunito)),
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF83859C),
                                    )
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFFEDEEF2),
                                            shape = RoundedCornerShape(size = 100.dp)
                                        )
                                        .padding(10.dp, 1.dp)
                                ){
                                    Text(
                                        text = "Cuci",

                                        // Small 2 - semibold 12 (16, 0px)
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            lineHeight = 16.sp,
//                                            fontFamily = FontFamily(Font(R.font.nunito)),
                                            fontWeight = FontWeight(600),
                                            color = Color(0xFF545563),
                                        )
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFFEDEEF2),
                                            shape = RoundedCornerShape(size = 100.dp)
                                        )
                                        .padding(10.dp, 1.dp)
                                ){
                                    Text(
                                        text = "Kering",

                                        // Small 2 - semibold 12 (16, 0px)
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            lineHeight = 16.sp,
//                                            fontFamily = FontFamily(Font(R.font.nunito)),
                                            fontWeight = FontWeight(600),
                                            color = Color(0xFF545563),
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))
                        }

                    }
                }
            }

        }



        Row(modifier = Modifier
            .padding(top = 750.dp)
            .shadow(
                elevation = 30.dp,
                spotColor = Color(0x40435D6B),
                ambientColor = Color(0x40435D6B)
            )

            .fillMaxWidth()
            .height(120.dp)
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



private fun postGetOrder(
    mainViewModel: MainViewModel,
    NavController: NavHostController
) {

    var url = "https://cuciin.anandadf.my.id/"
    // on below line we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()
    // below the line is to create an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    // passing data from our text fields to our model class.
    val getOrderRequest = GetOrderRequest(mainViewModel.customerId)
    // calling a method to create an update and passing our model class.
    val call: Call<GetOrderResponse?>? = retrofitAPI.getOrder(getOrderRequest)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<GetOrderResponse?> {
        override fun onResponse(call: Call<GetOrderResponse?>?, response: Response<GetOrderResponse?>) {
            val model: GetOrderResponse? = response.body()
            // on below line we are getting our data from model class
            // and adding it to our string.

            val status: Boolean? = model?.success
            if (status==true) {
                mainViewModel.listOrder = model.data.pesanan
            }
        }

        override fun onFailure(call: Call<GetOrderResponse?>?, t: Throwable) {
            // we get error response from API.
        }
    })

}




