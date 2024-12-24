package com.bap.rockpaperscissors

import java.util.Locale
import kotlin.random.Random

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")

    println("Welcome to Rock, Paper, Scissors!")
    while (true) {
        // Prompt user for their choice
        println("Choose your move (Rock, Paper, Scissors). Type 'Exit' to quit:")
        val playerChoice = readln().capitalize(Locale.ROOT)

        if (playerChoice == "Exit") {
            println("Thanks for playing! Goodbye!")
            break
        }

        if (playerChoice !in options) {
            println("Invalid choice. Please choose Rock, Paper, or Scissors.")
            continue
        }

        // Generate computer's choice
        val computerChoice = options[Random.nextInt(options.size)]

        println("You chose: $playerChoice")
        println("Computer chose: $computerChoice")

        // Determine the winner
        when {
            playerChoice == computerChoice -> println("It's a tie!")
            playerChoice == "Rock" && computerChoice == "Scissors" -> println("You win! Rock beats Scissors.")
            playerChoice == "Paper" && computerChoice == "Rock" -> println("You win! Paper beats Rock.")
            playerChoice == "Scissors" && computerChoice == "Paper" -> println("You win! Scissors beats Paper.")
            else -> println("You lose! $computerChoice beats $playerChoice.")
        }

        println()
    }
}