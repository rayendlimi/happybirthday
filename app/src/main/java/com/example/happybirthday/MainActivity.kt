package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource

import com.example.happybirthday.ui.theme.HappyBIrthdayTheme
import com.example.happybirthday.Topic
import com.example.happybirthday.DataSource

//======================>>>>>>>>>>>>>>> voila le tp4<<<<<<<<<<<<===================
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            HappyBIrthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_small),
                            top = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_small),
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.imageRes),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.padding_medium))
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicPreview() {
    HappyBIrthdayTheme {
        val topic = Topic(R.string.photography, 321, R.drawable.photography)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }
    }
}





//======================>>>>>>>>>>>>>>> voila le tp3<<<<<<<<<<<<===================
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBIrthdayTheme {
                Artspace(modifier= Modifier)
            }
        }
    }
}
@Composable
 fun Artspace(modifier: Modifier){
    val firstArtwork = R.drawable.traveler
    val secondArtwork = R.drawable.sayu
    val thirdArtwork = R.drawable.gamer
    val fourthArtwork = R.drawable.barbara

    var title by remember {
        mutableStateOf(R.string.traveler)
    }

    var year by remember {
        mutableStateOf(R.string.traveler_year)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }

    var imageResource by remember {
        mutableStateOf(currentArtwork)
    }

     Column( horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center,
         modifier = Modifier.fillMaxSize()) {

             Artspacedisplay(CurrentArtwork = currentArtwork)
             Spacer(modifier = modifier.size(16.dp))
         Artspacetitle(title = title, year = year)
             Spacer(modifier = modifier.size(25.dp))
             Row(
                 modifier = modifier.padding(horizontal = 8.dp),
                 horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
             )


             {
                 Button(
                     colors = ButtonDefaults.buttonColors(
                         containerColor = Color(0xFFeba443)
                     ),
                     onClick = {
                         when (currentArtwork) {
                             firstArtwork -> {
                                 currentArtwork = fourthArtwork
                                 title = R.string.sayu
                                 year = R.string.sayu_year
                             }
                             secondArtwork -> {
                                 currentArtwork = firstArtwork
                                 title = R.string.gaming
                                 year = R.string.gaming_year
                             }
                             thirdArtwork -> {
                                 currentArtwork = secondArtwork
                                 title = R.string.barbara
                                 year = R.string.barbara_year
                             }
                             else -> {
                                 currentArtwork = thirdArtwork
                                 title = R.string.traveler
                                 year = R.string.traveler_year
                             }
                         }
                     },


                     ) {
                     Text(
                         text = "Previous",
                         fontSize = 16.sp,

                         )
                 }

                 Button(
                     colors = ButtonDefaults.buttonColors(
                         containerColor = Color(0xFFeba443)
                     ),
                     onClick = {
                         when (currentArtwork) {
                             firstArtwork -> {
                                 currentArtwork = secondArtwork
                                 title = R.string.sayu
                                 year = R.string.sayu_year
                             }
                             secondArtwork -> {
                                 currentArtwork = thirdArtwork
                                 title = R.string.gaming
                                 year = R.string.gaming_year
                             }
                             thirdArtwork -> {
                                 currentArtwork = fourthArtwork
                                 title = R.string.barbara
                                 year = R.string.barbara_year
                             }
                             else -> {
                                 currentArtwork = firstArtwork
                                 title = R.string.traveler
                                 year = R.string.traveler_year
                             }
                         }
                     },


                     ) {
                     Text(
                         text = "Next",
                         fontSize = 16.sp,
                         fontWeight = FontWeight.Medium,
                     )
                 }
             }
         }
     }
@Composable
fun Artspacedisplay(modifier: Modifier = Modifier, @DrawableRes CurrentArtwork:Int) {
    Image(
        painter = painterResource(CurrentArtwork),
        contentDescription = stringResource(id = R.string.sayu),
        modifier = modifier.fillMaxWidth()
    )
}
    @Composable
    fun Artspacetitle( @StringRes title : Int, @StringRes year : Int){

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalAlignment= Alignment.CenterHorizontally)
            {
            Text(text = " ${stringResource(id = title)}" , fontWeight = FontWeight.Bold)

                Text(text = " ${stringResource(id = year)}",  fontWeight = FontWeight.Medium)
        }
    }

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBIrthdayTheme {
        Artspace(modifier=Modifier)
    }
}
*/
/*
//===================>>>>>>voila le TP 1<<<<<<<<<<<<=================

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBIrthdayTheme {
 fonction busnesscard de tp1
    Surface( modifier = Modifier.fillMaxSize() ){ BusnessCard() }

            }
        }
    }
}
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
             ContactInfo(iconres=R.drawable.msg, contact ="rayen.dlimi0107@gmail.com")
         }
    }
}
 @Composable
fun  ContactInfo(iconres: Int, contact : String){
    Row( verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(painter = painterResource(id= iconres ), contentDescription = null)
        Text(
            text = contact ,
            fontSize = 16.sp,
           color =Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBIrthdayTheme {

     BusnessCard()

    }
}
*/

/*
//=================>>>>>> Voila le tp2<<<<<<<<<================

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBIrthdayTheme {
                        LemonApp()
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

    @Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBIrthdayTheme {
           LemonApp()
    }
}
 */

