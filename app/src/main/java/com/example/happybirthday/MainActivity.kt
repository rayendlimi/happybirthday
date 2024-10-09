package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import com.example.happybirthday.ui.theme.HappyBIrthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBIrthdayTheme {
 // fonction busnesscard de tp1
  //   Surface( modifier = Modifier.fillMaxSize() ){ BusnessCard() }
/* tp2*/ LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.lemon_tree))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                    )
                }
            }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.lemon_drink))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemon_drink_description),
                        modifier = Modifier.wrapContentSize().clickable {
                            currentStep = 3
                        }
                    )
                }
            }
            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.lemon_squeeze))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon_squeeze_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                }
            }
            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.lemon_restart))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.lemon_restart_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1 // Retour à l'étape 1 pour redémarrer le cycle
                            }
                    )
                }
            }
        }

        }
    }


/*
@Composable
fun BusnessCard() {
    val image= painterResource(R.drawable.msg)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background((Color(0xFF0F9D58)))
    ) {
        Image( alignment = Alignment.Center,
            painter = image, contentDescription =null )

        Text(
            text = stringResource(R.string.rayen_dlimi),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color =Color.White
        )
        Text(
            text = stringResource(R.string.mobile_developper),
            fontSize = 24.sp,
            color =Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
         Column(
             horizontalAlignment = Alignment.Start,
             verticalArrangement = Arrangement.spacedBy(8.dp),

         ){
             ContactInfo(iconres=R.drawable.msg, contact = "+21622474908")
             ContactInfo(iconres=R.drawable.msg, contact = "SocialmediaHandle")
             ContactInfo(iconres=R.drawable.msg, contact ="rayeN.dlimi0107@gmail.com")

         }
    }
}*/
 /* @Composable
fun  ContactInfo(iconres: Int, contact : String){
    Row( verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(painter = painterResource(id= iconres ), contentDescription = null)



        Text(
            text = contact ,
            fontSize = 16.sp,
      //      color =Color.White
    //    )
  //  }

}*/



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBIrthdayTheme {
     //fonction busnesscard de tp 1
    // BusnessCard()

        /*tp2*/ LemonApp()

    }
}


