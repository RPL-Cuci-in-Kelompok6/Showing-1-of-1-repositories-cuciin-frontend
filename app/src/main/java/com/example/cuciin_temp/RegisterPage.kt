package com.example.cuciin_temp

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
import androidx.compose.material3.TextFieldDefaults
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun RegisterPage() {
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
                text = "Create an \naccount",
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
            var username by remember { mutableStateOf("") }
            var password1 by remember { mutableStateOf("") }
            var password2 by remember { mutableStateOf("") }

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username or Email") },
                leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF5F5F5)
                )

            )

            Spacer(modifier = Modifier.height(15.dp))

            PasswordTextField(
                password = password1,
                onPasswordChange = { newPassword ->
                    password1 = newPassword
                },
                label = "Password"
            )

            Spacer(modifier = Modifier.height(15.dp))

            PasswordTextField(
                password = password2,
                onPasswordChange = { newPassword ->
                    password2 = newPassword
                },
                label = "Password"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "By clicking the Register button, you agree to the public offer",
                style = TextStyle(
                    fontSize = 12.sp,
//                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF676767),
                    )
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Tombol Rgister
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3D4EB0), // Change the background color here
                    contentColor = Color.White // Change the text color here
                )
            ) {
                Text(text = "Create Account")
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
                        text = "I Already Have an Account  ",
                        style = MaterialTheme.typography.bodySmall,
                    )
                    ClickableText(
                        text = AnnotatedString("Login"),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFF83758),
                            textDecoration = TextDecoration.Underline,
                        ),
                        onClick = {}
                    )
                }
            }
        }
    }
}
