class Coordinate_System(var width: Float, var height: Float, var xMin: Int, var xMax: Int, var yMin: Int, var yMax: Int){

    fun x_to_the_Cartesian_system(xn: Float): Float{
        return xn / (width / (xMax - xMin)) + xMin
    }

    fun y_to_the_Cartesian_system(yn: Float): Float{
        return -(yn / (height / (yMax - yMin)) - yMax)
    }

    fun x_to_the_Screen_system(xd: Float): Float{
        return (xd - xMin) * (width / (xMax - xMin))
    }

    fun y_to_the_Screen_system(yd: Float): Float{
        return (yMax - yd) * (height / (yMax - yMin))
    }
}