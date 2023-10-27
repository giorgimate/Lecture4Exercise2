package com.example.secondexercise

fun main() {
    val number = writeNumber()
    var result = ""
    if (number in 1..1000) {
        var numberString = number.toString()
        result = when (numberString.length) {
            1 -> mainMap[number]!!
            2 -> {
                getDozen(number)

            }

            3 -> {
                wholeHundreedMap[number] ?: (HundreedMap[number / 100]!! + getDozen(number % 100))
            }

            else -> {
                "ათასი"
            }
        }
    }
    print(result)
}

fun getDozen(number: Int): String {

    return wholeDozenMap[number] ?: mainMap[number] ?: run {
        dozenMap[number / 10] + getUnit(number)
    }

}

fun getUnit(number: Int): String {
    if ((number / 10) % 2 == 0) {
        return mainMap[number % 10]!!
    }
    return mainMap[number % 10 + 10]!!
}

fun writeNumber(): Int {
    println("შემოიყვანეთ რიცხვი")
    var inputNumber = readln()
    val number  = inputNumber.toInt()
    return number
}
val mainMap = mapOf(
    1 to "ერთი",
    2 to "ორი",
    3 to "სამი",
    4 to "ოთხი",
    5 to "ხუთი",
    6 to "ექვსი",
    7 to "შვიდი",
    8 to "რვა",
    9 to "ცხრა",
    11 to "თერთმეტი",
    12 to "თორმეტი",
    13 to "ცამეტი",
    14 to "თოთხმეტი",
    15 to "თხუთმეტი",
    16 to "თექსვმეტი",
    17 to "ჩვიდმეტი",
    18 to "თვრამეტი",
    19 to "ცხრამეტი"

)

val wholeDozenMap = mapOf(
    10 to "ათი",
    20 to "ოცი",
    30 to "ოცდაათი",
    40 to "ორმოცი",
    50 to "ორმოცდათი",
    60 to "სამოცი",
    70 to "სამოცდაათი",
    80 to "ოთხმოცი",
    90 to "ოთხმოცდაათი"
)
val dozenMap = mapOf(

    2 to "ოცდა",
    3 to "ოცდა",
    4 to "ორმოცდა",
    5 to "ორმოცდა",
    6 to "სამოცდა",
    7 to "სამოცდა",
    8 to "ოთხმოცდა",
    9 to "ოთხმოცდა"
)
val HundreedMap = mapOf(
    1 to "ას ",
    2 to "ორას ",
    3 to "სამას ",
    4 to "ოთხას ",
    5 to "ხუთას ",
    6 to "ექვსას ",
    7 to "შვიდას ",
    8 to "რვაას ",
    9 to "ცხრაას "
)
val wholeHundreedMap = mapOf(
    100 to "ასი",
    200 to "ორასი",
    300 to "სამასი",
    400 to "ოთხასი",
    500 to "ხუთასი",
    600 to "ექვსასი",
    700 to "შვიდასი",
    800 to "რვაასი",
    900 to "ცხრაასი"
)