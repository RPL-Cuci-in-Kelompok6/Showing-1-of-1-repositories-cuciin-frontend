package com.example.cuciin_temp

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cuciin_temp.model.CancelOrderRequest
import com.example.cuciin_temp.model.CancelOrderResponse
import com.example.cuciin_temp.model.LoginRequest
import com.example.cuciin_temp.model.LoginResponse
import com.example.cuciin_temp.network.RetrofitAPI
import com.example.cuciin_temp.ui.theme.Cuciin_tempTheme
import com.example.cuciin_temp.ui.theme.fontFamily
import com.example.cuciin_temp.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun Status(NavController: NavHostController, mainViewModel: MainViewModel) {
    val ctx = LocalContext.current
    var isVisible by rememberSaveable { mutableStateOf(false) }
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
                text = "Order",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.size(45.dp))
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp),
            text = "BOOKING BERHASIL",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Start,)
        )
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp),
            text = "Silhakan menuju ke tempat laundry",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = fontFamily,
                color = Color(0xFF000000),
                textAlign = TextAlign.Start,)
        )
        Spacer(modifier = Modifier.size(40.dp))
        Column(modifier = Modifier.padding(start = 35.dp)) {
            Column(modifier = Modifier
                .shadow(
                    elevation = 39.969417572021484.dp,
                    spotColor = Color(0x1FAAAAAA),
                    ambientColor = Color(0x1FAAAAAA)
                )
                .width(320.dp)
                .height(400.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 39.96942.dp)
                )
                .padding(
                    start = 39.96942.dp,
                    top = 39.96942.dp,
                    end = 39.96942.dp,
                    bottom = 39.96942.dp
                ),
                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(modifier = Modifier
                    .fillMaxWidth(),
                    text = "Status Pesanan",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = Modifier.size(5.dp))
                Box(modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFF6E6F79))
                )
                Spacer(modifier = Modifier.size(10.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.Start),
                    ) {
                    Text(
                        text = "ID pesanan :",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                        )
                    )
                    Text(modifier = Modifier.fillMaxWidth(),
                        text = mainViewModel.selectedPesanan.id.toString(),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                            textAlign = TextAlign.End,
                        )
                    )
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                ) {
                    Text(
                        text = "Status :",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                        )
                    )
                    Text(modifier = Modifier.fillMaxWidth(),
                        text = mainViewModel.selectedPesanan.status,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                            textAlign = TextAlign.End,
                        )
                    )
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                ) {
                    Text(
                        text = "Email Pemesan :",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                        )
                    )
                    Text(modifier = Modifier.fillMaxWidth(),
                        text = mainViewModel.customerEmail,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                            textAlign = TextAlign.End,
                        )
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                Box(modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFF6E6F79))
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                ) {
                    Text(
                        text = "Total Pembayaran :",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                        )
                    )
                    Text(modifier = Modifier.fillMaxWidth(),
                        text = "Rp " + mainViewModel.selectedPesanan.totalHarga.toString(),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                            textAlign = TextAlign.End,
                        )
                    )
                }
                var statusPembayaran = ""
                if (mainViewModel.selectedPesanan.sudahBayar){
                    statusPembayaran = "Paid"
                } else statusPembayaran = "Not-Paid"
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                ) {
                    Text(
                        text = "Status Pembayaran :",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                        )
                    )
                    Text(modifier = Modifier.fillMaxWidth(),
                        text = statusPembayaran,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6E6F79),
                            textAlign = TextAlign.End,
                        )
                    )
                }
            }
        }


        Spacer(modifier = Modifier.size(40.dp))
        if(!mainViewModel.selectedPesanan.sudahBayar && mainViewModel.selectedPesanan.status != "canceled"){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier
                    .padding(top = 50.dp, start = 30.dp)
                    .width(150.dp)
                    .height(50.dp)
                    .background(
                        color = if (!mainViewModel.selectedPesanan.sudahBayar && mainViewModel.selectedPesanan.status != "canceled") {
                            Color(0xFF3D4EB0) // Warna ketika kondisi terpenuhi
                        } else {
                            Color(0xFFA6AFE6) // Warna ketika kondisi tidak terpenuhi
                        },
                        shape = RoundedCornerShape(size = 5.08002.dp)
                    )
                    .clickable {
                        if (!mainViewModel.selectedPesanan.sudahBayar && mainViewModel.selectedPesanan.status != "canceled") {
                            postCancelOrder(ctx, NavController, mainViewModel)
                        }
                    },

                    ) {
                    Text(modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxSize(),
                        text = "Batal",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 50.dp, start = 10.dp)
                        .width(150.dp)
                        .height(50.dp)
                        .background(
                            color = if (!mainViewModel.selectedPesanan.sudahBayar && mainViewModel.selectedPesanan.status != "canceled") {
                                Color(0xFF3D4EB0) // Warna ketika kondisi terpenuhi
                            } else {
                                Color(0xFFA6AFE6) // Warna ketika kondisi tidak terpenuhi
                            },
                            shape = RoundedCornerShape(size = 5.08002.dp)
                        )
                        .clickable {
                            if (!mainViewModel.selectedPesanan.sudahBayar && mainViewModel.selectedPesanan.status != "canceled"){
                                NavController.navigate("Booking")
                            }
                        },
                ) {
                    Text(modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxSize(),
                        text = "Bayar",
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


    }
}

private fun postCancelOrder(
    ctx: Context,
    NavController: NavHostController,
    mainViewModel: MainViewModel

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
    val cancelOrderRequest = CancelOrderRequest(mainViewModel.selectedPesanan.id)
    // calling a method to create an update and passing our model class.
    val call: Call<CancelOrderResponse?>? = retrofitAPI.cancelOrder(cancelOrderRequest)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<CancelOrderResponse?> {
        override fun onResponse(call: Call<CancelOrderResponse?>?, response: Response<CancelOrderResponse?>) {
            // this method is called when we get response from our api.

            // we are getting a response from our body and
            // passing it to our model class.
            val model: CancelOrderResponse? = response.body()
            // on below line we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code() + "\n" + model?.message
            Toast.makeText(ctx, resp, Toast.LENGTH_SHORT).show()
            val status: Boolean? = model?.success
            if (status==true) {
                NavController.navigate("Dashboard")
            }

        }

        override fun onFailure(call: Call<CancelOrderResponse?>?, t: Throwable) {
            // we get error response from API.
        }
    })

}


