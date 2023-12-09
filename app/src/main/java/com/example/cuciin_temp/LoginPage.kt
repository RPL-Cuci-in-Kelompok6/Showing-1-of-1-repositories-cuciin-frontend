package com.example.cuciin_temp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cuciin_temp.model.DataModel
import com.example.cuciin_temp.model.LoginRequest
import com.example.cuciin_temp.model.LoginResponse
import com.example.cuciin_temp.model.RegisterResponse
import com.example.cuciin_temp.network.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LoginPage(NavController: NavHostController) {
    val ctx = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Welcome\nBack!",
                style = TextStyle(
                    fontSize = 36.sp,
                    lineHeight = 43.sp,
//                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),

                    )
            )
            Spacer(modifier = Modifier.height(20.dp))

            // TextFields untuk username dan password
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF5F5F5)
                )

            )

            Spacer(modifier = Modifier.height(15.dp))

            PasswordTextField(
                password = password,
                onPasswordChange = { newPassword ->
                    password = newPassword
                },
                label = "Password"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box (
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopEnd){
                ClickableText(
                    text = AnnotatedString("Forgot Password?"),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFF83758),
                    ),
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Tombol Login
            Button(
                onClick = { LoginValidate(ctx, email, password, NavController) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3D4EB0),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.height(35.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp),
//            verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "- OR Continue with -",
                    style = MaterialTheme.typography.bodySmall,
                )


                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                ) {
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFF83758),
                                shape = RoundedCornerShape(size = 50.dp)
                            )
                            .width(54.dp)
                            .height(54.dp)
                            .background(
                                color = Color(0xFFFCF3F6),
                                shape = RoundedCornerShape(size = 50.dp)
                            )
                            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google1),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFF83758),
                                shape = RoundedCornerShape(size = 50.dp)
                            )
                            .width(54.dp)
                            .height(54.dp)
                            .background(
                                color = Color(0xFFFCF3F6),
                                shape = RoundedCornerShape(size = 50.dp)
                            )
                            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.apple1),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFF83758),
                                shape = RoundedCornerShape(size = 50.dp)
                            )
                            .width(54.dp)
                            .height(54.dp)
                            .background(
                                color = Color(0xFFFCF3F6),
                                shape = RoundedCornerShape(size = 50.dp)
                            )
                            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook1),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Create An Account  ",
                        style = MaterialTheme.typography.bodySmall,
                    )
                    ClickableText(
                        text = AnnotatedString("Sign Up"),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFF83758),
                            textDecoration = TextDecoration.Underline,
                        ),
                        onClick = {NavController.navigate("Register")}
                    )
                }
            }
        }
    }


}

private fun LoginValidate(
    ctx: Context,
    email: String,
    password: String,
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
    val loginRequest = LoginRequest(email, password)
    // calling a method to create an update and passing our model class.
    val call: Call<LoginResponse?>? = retrofitAPI.loginCustomer(loginRequest)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<LoginResponse?> {
        override fun onResponse(call: Call<LoginResponse?>?, response: Response<LoginResponse?>) {
            // this method is called when we get response from our api.

            // we are getting a response from our body and
            // passing it to our model class.
            val model: LoginResponse? = response.body()
            // on below line we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code() + "\n" + model?.message
            Toast.makeText(ctx, resp, Toast.LENGTH_SHORT).show()
            val status: Boolean? = model?.success
            if (status==true) NavController.navigate("Dashboard")

        }

        override fun onFailure(call: Call<LoginResponse?>?, t: Throwable) {
            // we get error response from API.
        }
    })

}
