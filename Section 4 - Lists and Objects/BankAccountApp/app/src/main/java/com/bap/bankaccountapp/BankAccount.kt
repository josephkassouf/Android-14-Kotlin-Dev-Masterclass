package com.bap.bankaccountapp

class BankAccount(private var accountHolder: String, private var balance: Double) {
    private val transactionHistory = mutableListOf<String>()

    fun deposit(amount: Double) {
        balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }

    fun withdraw(amount: Double) {
        if (amount <= balance) {
            balance -= amount
            transactionHistory.add("$accountHolder withdrew $$amount")
        } else {
            println("We dont have the funds to withdraw $$amount")
        }
    }

    fun displayTransactionHistory() {
        for (transaction in transactionHistory) {
            println(transaction)
        }
    }

    fun getName(): String {
        return accountHolder
    }

    fun accountBalance(): Double {
        return balance
    }
}