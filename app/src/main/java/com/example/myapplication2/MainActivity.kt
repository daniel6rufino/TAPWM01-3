package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.myapplication2.roomDB.PessoaDataBase
import com.example.myapplication2.ui.theme.MyApplication2Theme
import com.example.myapplication2.viewModel.PessoaViewModel
import com.example.myapplication2.viewModel.Repository
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            PessoaDataBase::class.java,
            "pessoa.db"
        ).build()
    }
}


private val viewModel by viewModels<PessoaViewModel>(
    factoryProducer = {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PessoaViewModel(Repository(db)) as T
            }
        }
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(viewModel: PessoaViewModel){
    val text: String = "teste"
    Column (
        Modifier
            .background(Color.Black)
    ) {
        Row (
            Modifier
                .padding(20.dp)
        ) {

        }

        Row (
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = "App DataBase",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }

        Row (
            Modifier
                .padding(20.dp)
        ) {

        }

        Row (
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = text,
                onValueChange = {},
                label = { Text(text = "Nome:")}
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = text,
                onValueChange = {},
                label = { Text(text = "Telefone:")}
            )
        }
        Row(
            Modifier
                .padding((20.dp))
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Button(onClick = {

            }) {
                Text(text = "Cadastrar")
            }
        }
        Row (
            Modifier
                .padding(20.dp)
        ) {

        }
    }
}

@Preview
@Composable
fun AppPreview(){
    MyApplication2Theme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            App()
        }
    }
}