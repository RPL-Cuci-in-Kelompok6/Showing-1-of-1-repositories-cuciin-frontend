package com.example.cuciin_temp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cuciin_temp.Booking
import com.example.cuciin_temp.DaftarLayanan
import com.example.cuciin_temp.DashboardPage
import com.example.cuciin_temp.HistoryPage
import com.example.cuciin_temp.LoginPage
import com.example.cuciin_temp.MitraPage
import com.example.cuciin_temp.Profile
import com.example.cuciin_temp.RegisterPage
import com.example.cuciin_temp.Status
import com.example.cuciin_temp.TypeCucian
import com.example.cuciin_temp.viewModel.MainViewModel


@Composable
fun navigation(mainViewModel : MainViewModel){
    val NavController = rememberNavController()
    NavHost(navController = NavController, startDestination = "Login"){
        composable(route = "Login"){
            LoginPage(NavController, mainViewModel)
        }
        composable(route = "Register"){
            RegisterPage(NavController)
        }
        composable(route = "Dashboard"){
            DashboardPage(NavController, mainViewModel)
        }
        composable(route = "Pesan"){
            MitraPage(NavController, mainViewModel)
        }
        composable(route = "History"){
            HistoryPage(NavController)
        }
        composable(route = "Layanan"){
            DaftarLayanan(NavController, mainViewModel)
        }
        composable(route = "Type"){
            TypeCucian(NavController, mainViewModel)
        }
        composable(route = "Booking"){
            Booking(NavController, mainViewModel)
        }
        composable(route = "Profile"){
            Profile(NavController, mainViewModel)
        }
        composable(route = "Status"){
            Status(NavController, mainViewModel)
        }


    }

}