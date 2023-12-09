package com.example.cuciin_temp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cuciin_temp.model.DataModel
import com.example.cuciin_temp.model.MitraX
import com.example.cuciin_temp.model.ServicesRequest
import com.example.cuciin_temp.model.ServicesResponses
import com.example.cuciin_temp.network.RetrofitAPI
import com.example.cuciin_temp.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MitraPage(NavController: NavHostController, mainViewModel: MainViewModel) {
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

                items(mainViewModel.MitraXListResponse) { item ->
                    MitraItem(item, NavController, mainViewModel)
                }
            }
            mainViewModel.getMitraX()



        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MitraItem(mitraX : MitraX, NavController: NavHostController, mainViewModel: MainViewModel) {
    val ctx = LocalContext.current
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            getServicesById(ctx, mitraX.id, mainViewModel, NavController)

        }

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


private fun getServicesById(
    ctx: Context,
    id: Int,
    mainViewModel: MainViewModel,
    NavController: NavHostController
) {
    try {
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
        val servicesRequest = ServicesRequest(id)
        // calling a method to create an update and passing our model class.
        val call: Call<ServicesResponses?>? = retrofitAPI.getServices(servicesRequest)
        // on below line we are executing our method.
        call!!.enqueue(object : Callback<ServicesResponses?> {
            override fun onResponse(call: Call<ServicesResponses?>?, response: Response<ServicesResponses?>) {
                // this method is called when we get response from our api.

                // we are getting a response from our body and
                // passing it to our model class.
                val model: ServicesResponses? = response.body()
                // on below line we are getting our data from model class
                // and adding it to our string.
                val resp =
                    "Response Code : " + response.code() + "\n"+
                            "Success : " + model?.success

                Toast.makeText(ctx, resp, Toast.LENGTH_SHORT).show()
                val status: Boolean? = model?.success
                if (status==true) {
                    mainViewModel.selectedMitra = model.data
                    NavController.navigate("Type")
                }


            }

            override fun onFailure(call: Call<ServicesResponses?>, t: Throwable) {
                // we get error response from API.
//            result.value = "Error found is : " + t.message
            }
        })

    }
    catch (e: Exception) {
        Toast.makeText(ctx, e.message.toString(), Toast.LENGTH_SHORT).show()
    }



}