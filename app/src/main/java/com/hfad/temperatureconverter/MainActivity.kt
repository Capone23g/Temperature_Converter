package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hfad.temperatureconverter.ui.theme.TemperatureConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainActivityComponent()




        }
    }
}
@Composable
fun Header(image: Int,description: String){
    Image(
        painter = painterResource(image), // Define the drawable to use
        contentDescription = description ,// description of image For accessibility
    modifier = Modifier
        .height(180.dp)
        .fillMaxWidth(),
        contentScale = ContentScale.Crop



    )




}
@Composable
fun TemperatureConverter(celsius:Int){
    val farenheit = (celsius.toDouble() * 9/5) + 32
    Text("$celsius Celsius is $farenheit Farenheit")


}
@Composable
fun convertButton(clicked: () -> Unit){
    Button(onClick = clicked) {
        Text("Convert")

    }


}





@Composable
fun mainActivityComponent(){
    Column {
        Header(image = R.drawable.sunrise, description = "sunrise image")
        TemperatureConverter(celsius = 0)

    }








}


@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    mainActivityComponent()


}

/*@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemperatureConverterTheme {
        Greeting("Android")
    }
}

 */