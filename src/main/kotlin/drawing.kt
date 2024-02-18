package drawing

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.drawText

import Function

@OptIn(ExperimentalTextApi::class)
fun draw_x_axis(scope: DrawScope, xMin: Int, xMax: Int, yMinMax: Float, textMeasurer: TextMeasurer){

    scope.drawLine(color = Color.Black,
        start = Offset(0f, scope.size.height*(1+yMinMax)/2),
        end = Offset(scope.size.width, scope.size.height*(1+yMinMax)/2)
    )

    for(i in xMin .. xMax) {
        scope.drawText(
            textMeasurer = textMeasurer, text = i.toString(),
            topLeft = Offset(
                scope.size.width * (i - xMin) / (xMax - xMin),
                scope.size.height * (1 + yMinMax) / 2
            )
        )
    }
}

@OptIn(ExperimentalTextApi::class)
fun draw_y_axis(scope: DrawScope, xMin: Int, xMax: Int, yMin: Int, yMax: Int, textMeasurer: TextMeasurer){
    scope.drawLine(color = Color.Black,
        start = Offset(-scope.size.width*xMin/(xMax-xMin), 0f),
        end = Offset(-scope.size.width*xMin/(xMax-xMin), scope.size.height)
    )
    for(i in yMin..yMax) {
        scope.drawText(
            textMeasurer = textMeasurer, text = i.toString(),
            topLeft = Offset(
                (0 - xMin) * scope.size.width / (xMax - xMin),
                (yMax - i) * scope.size.height / (yMax - yMin)
            )
        )
    }
}

fun graphic_drawing(scope: DrawScope, f:Function) {
    for(i in 0..f.points.size - 2){
        scope.drawLine(
            color = f.color,
            start = Offset(f.S.x_to_the_Screen_system(f.points[i].x), f.S.y_to_the_Screen_system(f.points[i].y)),
            end = Offset(f.S.x_to_the_Screen_system(f.points[i + 1].x), f.S.y_to_the_Screen_system(f.points[i + 1].y))
        )
    }
}