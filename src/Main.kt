import kotlin.math.sqrt
data class Point(val x: Double, val y: Double) {
    fun distanceTo(other: Point): Double {
        return sqrt((other.x - x) * (other.x - x) + (other.y - y) * (other.y - y))
    }
}
fun main() {
    println("Программа для нахождения минимального и максимального расстояния между точками на координатной плоскости.")

    fun readInt(prompt: String): Int {
        while (true) {
            print(prompt)
            val input = readLine()
            if (input.isNullOrBlank()) {
                println("Ошибка ввода: Ввод не может быть пустым.")
                continue
            }

            val number = input.toIntOrNull()
            if (number != null && number > 2) return number

            println("Ошибка ввода: Пожалуйста, введите целое число больше 2.")
        }
    }

    fun readCoordinate(prompt: String): Double {
        while (true) {
            print(prompt)
            val input = readLine()
            if (input.isNullOrBlank()) {
                println("Ошибка ввода: Ввод не может быть пустым.")
                continue
            }

            val number = input.toDoubleOrNull()
            if (number != null) return number

            println("Ошибка ввода: Пожалуйста, введите корректное число.")
        }
    }

    val numberOfPoints = readInt("Введите количество точек (больше 2): ")

    val points = mutableListOf<Point>()
    println("Введите координаты точек:")

    repeat(numberOfPoints) { index ->
        while (true) {
            val x = readCoordinate("Точка ${index + 1} - X: ")
            val y = readCoordinate("Точка ${index + 1} - Y: ")
            val point = Point(x, y)

            if (points.contains(point)) {
                println("Ошибка: Точка с координатами ($x, $y) уже существует. Введите другую точку.")
            } else {
                points.add(point)
                break
            }
        }
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val distance = points[i].distanceTo(points[j])
            if (distance < minDistance) minDistance = distance
            if (distance > maxDistance) maxDistance = distance
        }
    }

    println("Минимальное расстояние между точками: $minDistance")
    println("Максимальное расстояние между точками: $maxDistance")
}