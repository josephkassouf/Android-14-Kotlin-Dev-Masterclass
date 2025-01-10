package com.bap.kotlinbasics

fun main() {

    // var dog = Dog("Daisy")
    var book1 = BookClass()

}

fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun askDetails() {
    println("Who is the coffee for?")
    val name = readln()

    println("How many pieces of sugar do you want?")
    val sugarCount = readln().toInt()

    makeCoffee(name,sugarCount)
//    makeCoffee("Joseph",1)
//    makeCoffee("Joseph",2)
//    makeCoffee("Joseph",3)
}
// Define function
fun makeCoffee(name: String, sugarCount: Int) {
    val spoon: String = if (sugarCount == 1) "spoon" else "spoons"

    if (sugarCount == 0) println("Coffee with no sugar for $name")
    println("Coffee with $sugarCount $spoon of sugar for $name")
}
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

    /*
    print("Enter your age: ")
    var age = readln().toInt()

    if (age >= 18) {
        println("Im old")
    } else {
        println("Not old enough")
    }
    */