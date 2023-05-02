package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    MainActivityContent()
                }

            }

        }
    }
}

@Composable
fun Header(image: Int, description: String) {
    Image(
        painter = painterResource(image), // Define the drawable to use
        contentDescription = description,// description of image For accessibility
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop


    )


}

@Composable
fun TemperatureText(celsius: Int) {
    val fahrenheit = (celsius.toDouble() * 9 / 5) + 32
    Text("$celsius Celsius is $fahrenheit Fahrenheit")


}

@Composable
fun ConvertButton(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("Convert")

    }


}


@Composable
fun MainActivityContent() {
    val celsius = remember { mutableStateOf(0) }
    val newCelsius = remember{ mutableStateOf("")}
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        Header(image = R.drawable.sunrise, description = "sunrise image")
        EnterTemperature(temperature = newCelsius.value) { newCelsius.value = it }

        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            ConvertButton {
                newCelsius.value.toIntOrNull()?.let {
                    //If newCelsius value is an int, assign it to celsius value
                    celsius.value = it
                }
            }

        }

        TemperatureText(celsius.value)


    }


}
@Composable
fun EnterTemperature(temperature: String,changed: (String) -> Unit ){
    TextField(
        value = temperature,
        onValueChange = changed,
        label = {Text("Enter a temperature in celsius ")},
        modifier = Modifier.fillMaxWidth()

    )


}




@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    MainActivityContent()


}

/*
@Composable
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