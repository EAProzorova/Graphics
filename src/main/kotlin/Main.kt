import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import drawing.*
import androidx.compose.foundation.background
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

fun task1(x: Float): Float{

    return x + (1 / x.pow(3))
}

fun task2(t: Float): Offset {

    return Offset(sin(4*t.toDouble()).toFloat(), cos(t.toDouble()).toFloat())
}




@OptIn(ExperimentalTextApi::class)
@Composable
@Preview
fun App() {
    val xMinMax by remember{mutableStateOf(0f)}
    val xMin = (-10 + 10 * xMinMax).toInt()
    val xMax = (10 + 10 * xMinMax).toInt()

    val yMinMax by remember{mutableStateOf(0f)}
    val yMin = (-10 + 10 * yMinMax).toInt()
    val yMax = (10 + 10 * yMinMax).toInt()

    val textMeasurer = rememberTextMeasurer()


    var tMin by remember { mutableStateOf(-10) }
    var tMax by remember { mutableStateOf( 10) }


    Canvas(modifier = Modifier.fillMaxSize(),
        onDraw = {
            draw_x_axis(this, xMin, xMax, yMinMax, textMeasurer)
            draw_y_axis(this, xMin, xMax, yMin, yMax, textMeasurer)


            val Task1 = Function(::task1, null, Color.Green,
                this.size.width,
                this.size.height, xMin, xMax, yMin, yMax, )
            Task1.function(this)
            graphic_drawing(this, Task1)

            val Task2 = Function(null, ::task2, Color.Red,
                this.size.width,
                this.size.height, xMin, xMax, yMin, yMax, tMin, tMax)
            Task2.function(this)
            graphic_drawing(this, Task2)
        }

    )
    Column (modifier = Modifier.fillMaxSize(0.40f)){
        Row {

            Text("Функция №1:  y = x+(1/x^3) ", modifier = Modifier.height(50.dp).weight(4f).padding(5.dp, 15.dp), textAlign = TextAlign.Center)
            Column(modifier = Modifier.height(50.dp).weight(1f)){
                Row(modifier = Modifier.weight(7f).background(Color.White)){
                    Box(modifier = Modifier.weight(1f))
                }
                Row(modifier = Modifier.weight(1f).background(Color.Green)){
                    Box(modifier = Modifier.weight(1f))
                }
                Row(modifier = Modifier.weight(7f).background(Color.White)){
                    Box(modifier = Modifier.weight(1f))
                }
            }
        }
        Row {

            Text("Функция №2:", modifier = Modifier.height(50.dp).weight(3f).padding(5.dp, 15.dp), textAlign = TextAlign.Center)
            Column(modifier = Modifier.height(50.dp).weight(2f)){
                Row(modifier = Modifier.weight(1f)){
                    Text("x = sin (4t)", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }
                Row(modifier = Modifier.weight(1f)){
                    Text("y = cos (t)", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }
            }
            Column(modifier = Modifier.height(50.dp).weight(1f)){
                Row(modifier = Modifier.weight(7f).background(Color.White)){
                    Box(modifier = Modifier.weight(1f))
                }
                Row(modifier = Modifier.weight(1f).background(Color.Red)){
                    Box(modifier = Modifier.weight(1f))
                }
                Row(modifier = Modifier.weight(7f).background(Color.White)){
                    Box(modifier = Modifier.weight(1f))
                }
            }
        }
        Row{
            Text("Параметр t:", modifier = Modifier.height(50.dp).weight(2f).padding(5.dp, 15.dp), textAlign = TextAlign.Center)
            Box(modifier = Modifier.weight(1f)){
                TextField(value = tMin.toString(),
                    onValueChange = { value -> tMin = value.toIntOrNull() ?:-10 },
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    modifier = Modifier.height(50.dp)
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                TextField(value = tMax.toString(),
                    onValueChange = { value -> tMax = value.toIntOrNull() ?: 10 },
                    modifier = Modifier.height(50.dp)
                )
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
