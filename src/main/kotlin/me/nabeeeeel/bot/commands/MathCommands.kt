package me.nabeeeeel.bot.commands

import me.jakejmattson.discordkt.api.arguments.DoubleArg
import me.jakejmattson.discordkt.api.arguments.IntegerArg
import me.jakejmattson.discordkt.api.arguments.MultipleArg
import me.jakejmattson.discordkt.api.commands.commands
import kotlin.math.sqrt


// creates category
fun mathCommands() = commands("Math") {

    command("Add") {
        description = "add two numbers"
        execute(DoubleArg("First #"), DoubleArg("Second #").optional(0.0)) {
            val (first, second) = args
            respond("Result: ${first + second}")
        }
    }

    command("Sum") {
        description = "get sum of numbers"
        execute(MultipleArg(IntegerArg)) {
            val sum = args.first.sum()
            respond("Result: $sum")
        }
    }

    command("Product", "Multiply", "Mul", "Times") {
        description = "get product of numbers"
        execute(MultipleArg(DoubleArg)) {

            val sum = args.first.toList().fold(1.0) { sum, next -> sum * next }
            respond("Result: ${"$.1f".format(sum)}")
        }
    }

    command("Divide", "Div") {
        description = "get quotient of two numbers"
        execute((DoubleArg("First #")), DoubleArg("Second #").optional(1.0)) {
            val (first, second) = args
            respond("Result: ${"$.1f".format(first / second)}")
        }
    }

    command("SquareRoot") {
        description = "get the square root of a number"
        execute(DoubleArg("# to Square Root")) {
            val (first) = args
            respond("Result: ${"$.1f".format(sqrt(first))}")
        }
    }

    command("Square") {
        description = "get the square of a number"
        execute(DoubleArg("# to Square")) {
            val (first) = args
            respond("Result: ${"$.1f".format(first * first)}")

        }
    }

    command("Subtract") {
        description = "subtract two numbers"
        execute(DoubleArg("First # -"), DoubleArg("Second #").optional(0.0)) {
            val (first, second) = args
            respond("Result: ${first - second}")
        }
    }

}
