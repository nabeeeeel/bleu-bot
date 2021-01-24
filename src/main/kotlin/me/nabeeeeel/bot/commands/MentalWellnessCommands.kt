package me.nabeeeeel.bot.commands

import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.services.ListService
import java.awt.Color


// creates category
fun mentalWellnessCommands(listService: ListService) = commands("Compliments") {

    command("Compliment", "Comp", "C") {
        description = "get a compliment"
        execute(UserArg("@username").makeOptional { it.author }) {
            val user = args.first
            respond {
                // thumbnail { url = user.avatar.url }
                author {
                    name = user.username
                    icon = user.avatar.url

                }
                title = "Y O U  T H E  B E S T"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                description = listService.compliments.random()
            }

        }
    }
}

