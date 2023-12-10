package com.example.cuciin_temp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cuciin_temp.model.Layanan
import com.example.cuciin_temp.ui.theme.Cuciin_tempTheme
import com.example.cuciin_temp.ui.theme.fontFamily
import com.example.cuciin_temp.viewModel.MainViewModel


@Composable
fun TypeCucian(NavController: NavHostController, mainViewModel: MainViewModel) {
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
                .clickable { NavController.navigate("Pesan") },
                painter = painterResource(id = R.drawable.panah),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Text( modifier = Modifier
                .width(200.dp)
                .height(32.dp),
                text = "Tipe Cucian",
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
            text = "Available",
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
            Columns(mainViewModel)
        }

        val response = remember {
            mutableStateOf(Layanan(0,0, emptyList(),""))
        }

        Column(modifier = Modifier
            .padding(top = 50.dp, start = 40.dp)
            .width(306.dp)
            .height(50.dp)
            .background(color = Color(0xFF3D4EB0), shape = RoundedCornerShape(size = 5.08002.dp))
            .clickable { NavController.navigate("Layanan") },

            ) {
            Text(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize(),
                text = "Confirm",
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
fun MyChoice(
    type: Layanan,
    isSelected: Boolean,
    onSelected: (Layanan) -> Unit,
    mainViewModel: MainViewModel
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onSelected(type) },
        shape = RoundedCornerShape(8.dp),
        color = if (isSelected) Color(0xFF8F9FFF) else Color(0xFF47B7DD)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = { onSelected(type) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                modifier = Modifier
                    .width(20.dp)
                    .height(14.49874.dp),
                painter = painterResource(id = R.drawable.setrika),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = type.nama,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
                Text(
                    text = type.harga.toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            }
        }
    }
}



@Composable
fun Columns(mainViewModel: MainViewModel) {
    val types = mainViewModel.selectedMitra.layanan
    var selectedType by remember { mutableStateOf<Layanan?>(null) }
    if (selectedType != null){
        mainViewModel.selectedLayanan = selectedType!!
    }

    if(types != null){
        LazyColumn {
            items(types) { type ->
                MyChoice(
                    type = type,
                    isSelected = type == selectedType,
                    onSelected = { selectedType = it },
                    mainViewModel
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    } else{
        Text(
            text = "Maaf, Tidak ada layanan yang tersedia",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )
        )
    }


}



