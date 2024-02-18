import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope



//class Function (val task_1: (Float)->Float, _color: Color,
//                width: Float, height: Float, xMin: Int, xMax: Int, yMin: Int, yMax: Int,
//                task_num: Int, val tMin: Int = 0, val tMax: Int = 0){
//
//    var points = mutableListOf<Offset>()
//    var color = _color
//    var S = Coordinate_System(width, height, xMin, xMax, yMin, yMax)
//    var task = task_num
//
//
//
//    fun function(scope: DrawScope){
//        if (task == 1){                                             //y= y(x)
//            var x = 0f
//            var _y = 0f
//            for (i in 0..scope.size.width.toInt()){
//                x = S.x_to_the_Cartesian_system(i.toFloat())
//                try{
//                    _y = task_1(x)
//                    points += Offset(x, _y)
//                }
//                catch (e: Exception){
//
//                }
//            }
//        }
//        if(task == 2){                                                  //x(t), y(t)
//            var t = tMin.toFloat()
//            while(t != tMax.toFloat()){
//                points += task2(t)
//                t += 0.25f                                                  //float
//            }
//        }
//    }
//}

class Function (var task_1: ((Float)->Float?)? = null,
                var task_2: ((Float)->Offset?)? = null,
                _color: Color,
                width: Float, height: Float, xMin: Int, xMax: Int, yMin: Int, yMax: Int,
                val tMin: Int = 0, val tMax: Int = 0){

    var points = mutableListOf<Offset>()
    var color = _color
    var S = Coordinate_System(width, height, xMin, xMax, yMin, yMax)

    fun function(scope: DrawScope){
        if (task_1 != null){                                             //y= y(x)
            var x = 0f
            var _y = 0f
            for (i in 0..scope.size.width.toInt()){
                x = S.x_to_the_Cartesian_system(i.toFloat())
                try{
                    _y = task_1?.let { it(x) }!!

                    points += Offset(x, _y)
                }
                catch (e: Exception){

                }
            }
        }
        if(task_2 != null){                                                  //x(t), y(t)
            var t = tMin.toFloat()
            while(t != tMax.toFloat()){
                points += task_2?.let { it(t) }!!
                t += 0.25f                                                  //float
            }
        }
    }
    //jhsjdh
    //uyuy
}