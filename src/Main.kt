import kotlin.math.pow
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.math.sqrt

fun main() {
    try {
        println("Максимальное из двух чисел: ${maxOf(7,5)}")
        println("Деление: ${divide(10.0, 2.0)}")
        println("Строка в число: ${stringToInt("123")}")
        validateAge(25)
        println("Квадратный корень: ${findSquareRoot(16.0)}")
        println("Факториал: ${factorial(5)}")

        val array = arrayOf(1, 2, 3, 4, 5)
        checkArrayForZeros(array)
        println("Возведение в степень: ${power(2.0, 3)}")
        println("Обрезанная строка: ${trimString("Hello, World!", 5)}")
        println("Элемент найден на индексе: ${findElement(array, 3)}")

        println(toBinaryString(10)) // "1010"
        println(isDivisible(10, 2)) // true
        println(getElementFromList(listOf(1, 2, 3), 1)) // 2
        checkPasswordStrength("strongPass") // Нет исключения
        println(isValidDate("01.01.2020")) // true
        println(concatenateStrings("Привет, ", "Мир!")) // "Привет, Мир!"
        println(getRemainder(10, 3)) // 1
        println(calculateSquareRoot(16.0)) // 4.0
        println(celsiusToFahrenheit(0.0)) // 32.0
        validateString("Не пустая строка") // Нет исключения

    } catch (e: Exception) {
        println(e.message)
    }
}
// 1. Найти максимальное из двух чисел
fun maxOf(nOne: Int, nTwo : Int) : Int {
    var max = 0
    if (nOne == nTwo){ throw  Exception("Числа одинаковы!")}
    else if (nOne > nTwo) max = nOne
    else max = nTwo
    return max
}
// 2. Калькулятор деления
fun divide(numerator: Double, denominator: Double): Double {
    if (denominator == 0.0) {
        throw ArithmeticException("Деление на ноль запрещено.")
    }
    return numerator / denominator
}

// 3. Конвертер строк в числа
fun stringToInt(str: String): Int {
    return str.toIntOrNull() ?: throw NumberFormatException("Неверная строка для преобразования в число: $str")
}

// 4. Проверка возраста
fun validateAge(age: Int) {
    if (age < 0 || age > 150) {
        throw IllegalArgumentException("Возраст должен быть от 0 до 150. Указано: $age")
    }
}

// 5. Нахождение корня
fun findSquareRoot(number: Double): Double {
    if (number < 0) {
        throw IllegalArgumentException("Невозможно вычислить квадратный корень из отрицательного числа: $number")
    }
    return kotlin.math.sqrt(number)
}

// 6. Факториал
fun factorial(number: Int): Long {
    if (number < 0) {
        throw IllegalArgumentException("Факториал не определен для отрицательных чисел: $number")
    }
    var result = 1L
    for (i in 1..number) {
        result *= i
    }
    return result
}

// 7. Проверка массива на нули
fun checkArrayForZeros(array: Array<Int>) {
    for ((index, num) in array.withIndex()) {
        if (num == 0) {
            throw IllegalArgumentException("Массив содержит ноль на индексе: $index")
        }
    }
}

// 8. Калькулятор возведения в степень
fun power(base: Double, exponent: Int): Double {
    if (exponent < 0) {
        throw IllegalArgumentException("Отрицательные степени не допускаются: $exponent")
    }
    return base.pow(exponent.toDouble())
}

// 9. Обрезка строки
fun trimString(str: String, length: Int): String {
    if (length > str.length) {
        throw IllegalArgumentException("Длина превышает размер строки. Длина строки: ${str.length}, указано: $length")
    }
    return str.substring(0, length)
}

// 10. Поиск элемента в массиве
fun findElement(array: Array<Int>, element: Int): Int {
    for ((index, value) in array.withIndex()) {
        if (value == element) {
            return index
        }
    }
    throw IllegalArgumentException("Элемент не найден в массиве: $element")
}

// 11. Конвертация в двоичную систему
fun toBinaryString(number: Int): String {
    if (number < 0) throw IllegalArgumentException("Отрицательные числа не допускаются.")
    return Integer.toBinaryString(number)
}

// 12. Проверка делимости
fun isDivisible(a: Int, b: Int): Boolean {
    if (b == 0) throw ArithmeticException("Деление на ноль запрещено.")
    return a % b == 0
}

// 13. Чтение элемента списка
fun <T> getElementFromList(list: List<T>, index: Int): T {
    if (index !in list.indices) throw IndexOutOfBoundsException("Индекс $index вне диапазона.")
    return list[index]
}

// 14. Парольная проверка
class WeakPasswordException(message: String): Exception(message)

fun checkPasswordStrength(password: String) {
    if (password.length < 8) throw WeakPasswordException("Пароль должен содержать минимум 8 символов.")
}

// 15. Проверка даты
fun isValidDate(dateString: String): Boolean {
    return try {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        LocalDate.parse(dateString, formatter)
        true
    } catch (e: DateTimeParseException) {
        throw DateTimeParseException("Неверный формат даты: $dateString", dateString, 0)
    }
}

// 16. Конкатенация строк
fun concatenateStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) throw NullPointerException("Одна или обе строки равны null.")
    return str1 + str2
}

// 17. Остаток от деления
fun getRemainder(a: Int, b: Int): Int {
    if (b == 0) throw ArithmeticException("Деление на ноль запрещено.")
    return a % b
}

// 18. Квадратный корень
fun calculateSquareRoot(number: Double): Double {
    if (number < 0) throw IllegalArgumentException("Невозможно вычислить квадратный корень отрицательного числа.")
    return sqrt(number)
}

// 19. Конвертер температуры
fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) throw IllegalArgumentException("Температура ниже абсолютного нуля запрещена.")
    return celsius * 9 / 5 + 32
}

// 20. Проверка строки на пустоту
fun validateString(input: String?) {
    if (input.isNullOrEmpty()) throw IllegalArgumentException("Строка пуста или равна null.")
}
