package com.bap.bankaccountapp

fun main() {
    val joeBankAccount = BankAccount("Joe", 136.20)

    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    joeBankAccount.deposit(150.00)
    // joeBankAccount.withdraw(10000.00)

    joeBankAccount.displayTransactionHistory()
    println("${joeBankAccount.getName()} balance is ${joeBankAccount.accountBalance()}")
}