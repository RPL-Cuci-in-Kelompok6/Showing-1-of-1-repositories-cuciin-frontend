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


@Composable
fun navigation(){
    val NavController = rememberNavController()
    NavHost(navController = NavController, startDestination = "Dashboard"){
        composable(route = "Login"){
            LoginPage(NavController)
        }
        composable(route = "Register"){
            RegisterPage(NavController)
        }
        composable(route = "Dashboard"){
            DashboardPage(NavController)
        }
        composable(route = "Pesan"){
            MitraPage(NavController)
        }
        composable(route = "History"){
            HistoryPage(NavController)
        }
        composable(route = "Layanan"){
            DaftarLayanan(NavController)
        }
        composable(route = "Type"){
            TypeCucian(NavController)
        }
        composable(route = "Booking"){
            Booking(NavController)
        }
        composable(route = "Profile"){
            Profile(NavController)
        }
        composable(route = "Status"){
            Status(NavController)
        }


    }

}