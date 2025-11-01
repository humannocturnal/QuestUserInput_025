package com.example.questuserinput_025

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Praktikum (modifier: Modifier
){
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textstatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki","Perempuan")
    val statusoption: List<String> = listOf("Janda","Lajang","Duda")

    Column (modifier = Modifier.background(colorResource(id = R.color.gray))
    ){
        Box(Modifier.fillMaxWidth()
            .height(height = 100.dp)
            .background(colorResource(id = R.color.purlple)),
            contentAlignment = Alignment.BottomStart
        ){
            Text("formulir pendaftaran",
                modifier = Modifier.padding(15.dp),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(horizontal = 2.dp, vertical = 5.dp)
            .shadow(8.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .height(600.dp)
            .background(Color.White))
        {
            Column (modifier = Modifier
                .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp))
            {
                Text("NAMA LENGKAP",
                )
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.width(350.dp),

                    placeholder = { Text(text = "Isian Nama Lengkap") },

                    onValueChange = {
                        textNama = it
                    }
                )
                Text("JENIS KELAMIN")
                Column {
                    gender.forEach { item ->
                        Row (modifier = Modifier.selectable(
                            selected = textJK == item,

                            onClick = { textJK = item}
                        ), verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = textJK == item,

                                onClick = {
                                    textJK = item
                                })
                            Text(item)
                        }
                    }
                }
                Text("STATUS PERKAWINAN")
                Column {
                    statusoption.forEach { item ->
                        Row(modifier = Modifier.selectable(
                            selected = textstatus == item,

                            onClick = { textstatus = item}
                        ), verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = textstatus == item,

                                onClick = {
                                    textstatus = item
                                })
                            Text(item)
                        }
                    }
                }
                Text("ALAMAT",
                )
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.width(350.dp),

                    placeholder = { Text(text = "Alamat") },

                    onValueChange = {
                        textAlamat = it
                    }
                )
                Button (
                    modifier = Modifier.fillMaxWidth(1f),
                    enabled = textAlamat.isNotEmpty(),

                    onClick = {
                        nama=textNama
                        jenis=textJK
                        status=textstatus
                        alamat=textAlamat
                    }
                ) {
                    Text(stringResource(R.string.submit))
                }
            }
        }
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard (
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            ){
                Column (modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp),){
                    Text(text = "NAMA : "+nama, color = Color.Black, fontWeight = FontWeight.Bold)
                    Text(text = "JENIS KELAMIN : "+jenis, color = Color.Black, fontWeight = FontWeight.Bold)
                    Text(text = "STATUS PERKAWINAN : "+status ,color = Color.Black, fontWeight = FontWeight.Bold)
                    Text(text = "ALAMAT : "+alamat, color = Color.Black, fontWeight = FontWeight.Bold)

                }
            }
        }
    }
}







