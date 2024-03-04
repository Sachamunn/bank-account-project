package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
var userChoice: String = ""
var accountType: String = ""
var accountBalance = 0
var output = 0


fun withdraw(amount: Int): Int {
    if (accountType == "debit") {
        if ((accountBalance - amount) >= 0) {
            accountBalance -= amount
            println("You have withdraw $amount. You balance is: $accountBalance")
        } else {
            println("You don't have enough money for this operation. Your balance is: $accountBalance")
            return 0
        }
    } else if(accountType == "checking" || accountType == "credit") {
        accountBalance -= amount
        println("You have withdraw $amount. You balance is: $accountBalance")
    }
    return amount
}

fun deposit(amount: Int): Int {
    if (accountType == "debit") {
        accountBalance += amount
        println("You deposited $amount to your balance. Your new balance is: $accountBalance")
        return accountBalance
    } else {
        if ((accountBalance + amount > 0)) {
            println("You are trying to deposit amount that is higher than your credit. Your balance is: $accountBalance")
        } else if ((accountBalance + amount) < 0) {
            accountBalance += amount
            println("Amount deposited. Your balance is: $accountBalance")
        } else {
            accountBalance += amount
            println("You have paid off this account! Your balance now is: $accountBalance")
        }
    }
    return accountBalance
}

    fun main() {

        println(
            "Welcome to your banking system.\n" +
                    "What type of account would you like to create?\n" +
                    "1. Debit account\n" +
                    "2. Credit account\n" +
                    "3. Checking account\n" +
                    "Choose an option (1, 2 or 3)"
        )

        userChoice = readln()

        while (true) {
            when (userChoice) {
                "1" -> {
                    accountType = "debit"
                    break;
                }

                "2" -> {
                    accountType = "credit"
                    break
                }

                "3" -> {
                    accountType = "checking"
                    break
                }

                else -> {
                    println("You entered wrong value. Choose 1, 2 or 3...")
                    userChoice = readln()
                }

            }
        }

        println("You have created a $accountType account.")
        println("Please, enter amount of your first deposit (1 - 1000)")

        var userInput: Int = readln().toInt()

        while (true) {
            if (userInput in 1..1000) {
                accountBalance = userInput
                println("Your current balance: $accountBalance")
                break
            } else {
                println(
                    "You entered wrong amount. Accessed amount is 1 - 1000.\n" +
                            "Enter you amount again."
                )
                userInput = readln().toInt()
            }
        }

        withdraw(401)
        deposit(200)
    }
