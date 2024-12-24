package com.bap.kotlinbasics

fun main() {
    /*
    println("Hello World!")

    // Immutable REF const equivalent
    val number1 = 1
    println(number1)

    // Mutable REF
    // var myAge:Byte = 35 //Explicitly assigning type
    var myAge = 35 // Type inference
    println(myAge)

    myAge = 25
    println(myAge)
    */

    /*
    // Double and floating points
    val pi = 3.14
    println(pi)
    */

    /*
    // Unassigned 0 - positive numbers
    var age:UShort = 35u
    println(age)
    */

    print("Enter your age: ")
    var age = readln().toInt()

    if (age >= 18) {
        println("Im old")
    } else {
        println("Not old enough")
    }
}