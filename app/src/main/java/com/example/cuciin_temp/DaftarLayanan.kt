package com.example.cuciin_temp


import android.content.Context
import android.os.Bundle
import android.widget.Toast
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
import com.example.cuciin_temp.model.CreateOrderRequest
import com.example.cuciin_temp.model.CreateOrderResponse
import com.example.cuciin_temp.model.LoginRequest
import com.example.cuciin_temp.model.LoginResponse
import com.example.cuciin_temp.model.Mesin
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
fun DaftarLayanan(NavController: NavHostController, mainViewModel: MainViewModel) {

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
            text = mainViewModel.selectedLayanan.nama,
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
            if (mainViewModel.selectedLayanan.mesin != null){
                MyCardList(mainViewModel)
            }
        }
        val ctx = LocalContext.current

        Column(modifier = Modifier
            .padding(top = 50.dp, start = 40.dp)
            .width(306.dp)
            .height(50.dp)
            .background(color = Color(0xFF3D4EB0), shape = RoundedCornerShape(size = 5.08002.dp))
            .clickable {
                if(mainViewModel.selectedMesin != null){
                    postCreateOrder(ctx, NavController, mainViewModel)
                }
            },

            ) {
            Text(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize(),
                text = "Create Order",
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
fun MyCardList(mainViewModel: MainViewModel) {
    var selectedCard by remember { mutableStateOf<Mesin?>(null) }
    if (selectedCard != null){
        mainViewModel.selectedMesin = selectedCard!!
    }


    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(26.dp)
    ) {
        mainViewModel.selectedLayanan.mesin.forEachIndexed { index, card ->
            item(span = { GridItemSpan(1) }) {
                MyCard(
                    mesin = card,
                    isSelected = selectedCard == card,
                    onCardSelected = { selectedCard = card },
                    counter = index+1
                )
            }
        }
    }
}

@Composable
fun MyCard(
    mesin: Mesin,
    isSelected: Boolean,
    onCardSelected: () -> Unit,
    counter: Int
) {
    val backgroundColor = if (isSelected) {
        Color.Cyan // Change this to the color you want when clicked
    } else {
        Color.LightGray // Default color
    }

    Card(
        modifier = Modifier
            .width(107.13878.dp)
            .height(112.dp)
            .clickable { onCardSelected() }
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 5.08002.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
        )
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
            text = counter.toString(),
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
            text = mesin.merk,
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

private fun postCreateOrder(
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
    val createOrderRequest = CreateOrderRequest(mainViewModel.customerEmail,mainViewModel.selectedLayanan.harga, mainViewModel.customerId, mainViewModel.selectedMesin.id)
    // calling a method to create an update and passing our model class.
    val call: Call<CreateOrderResponse?>? = retrofitAPI.createOrder(createOrderRequest)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<CreateOrderResponse?> {
        override fun onResponse(call: Call<CreateOrderResponse?>?, response: Response<CreateOrderResponse?>) {
            // this method is called when we get response from our api.

            // we are getting a response from our body and
            // passing it to our model class.
            val model: CreateOrderResponse? = response.body()
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

        override fun onFailure(call: Call<CreateOrderResponse?>?, t: Throwable) {
            // we get error response from API.
        }
    })

}




