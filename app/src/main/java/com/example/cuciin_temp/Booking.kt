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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.cuciin_temp.model.LoginRequest
import com.example.cuciin_temp.model.LoginResponse
import com.example.cuciin_temp.model.PayOrderRequest
import com.example.cuciin_temp.model.PayOrderResponse
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
fun Booking(NavController: NavHostController, mainViewModel: MainViewModel) {
    val ctx = LocalContext.current
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
                .clickable { NavController.navigate("Status") },
                painter = painterResource(id = R.drawable.panah),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Text( modifier = Modifier
                .width(200.dp)
                .height(32.dp),
                text = "Pembayaran",
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
            text = "ID Pesanan : " + mainViewModel.selectedPesanan.id,
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.size(10.dp))
        Spacer(modifier = Modifier.size(40.dp))
        Text(modifier = Modifier
            .padding(start = 30.dp),
            text = "Pilih Metode Pembayaran",
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
            .clickable { postPayOrder(ctx, NavController, mainViewModel) },

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

private fun postPayOrder(
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
    val payOrderRequest = PayOrderRequest(mainViewModel.selectedPesanan.id)
    // calling a method to create an update and passing our model class.
    val call: Call<PayOrderResponse?>? = retrofitAPI.payOrder(payOrderRequest)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<PayOrderResponse?> {
        override fun onResponse(call: Call<PayOrderResponse?>?, response: Response<PayOrderResponse?>) {
            // this method is called when we get response from our api.

            // we are getting a response from our body and
            // passing it to our model class.
            val model: PayOrderResponse? = response.body()
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

        override fun onFailure(call: Call<PayOrderResponse?>?, t: Throwable) {
            // we get error response from API.
        }
    })

}