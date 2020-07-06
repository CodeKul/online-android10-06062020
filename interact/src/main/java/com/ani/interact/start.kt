package com.ani.interact

val nm = "android" //variable //assignment operator
val empsal = "android" //variable

fun dataMy() { // function
    val ft = 10
    val mt = 20
    val rt = mt + ft
}

fun connect(platform: String) { // function with parameter
    print(platform)
}

fun disconnect(os: Int): Boolean { // function is returning
    return (os == 1).not() // equality operator
}

fun reconnect(os: Int): Boolean = (os == 1)

fun main() {
    dataMy()

    connect("fb")

    disconnect(1)
    disconnect(2)

    reconnect(56)
}



