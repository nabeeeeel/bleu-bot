package me.nabeeeeel.bot.commands

import dev.kord.common.Color
import me.jakejmattson.discordkt.api.arguments.MemberArg
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.commands.commands
import me.nabeeeeel.bot.services.ListService


// creates category
fun mentalWellnessCommands(listService: ListService) = commands("Compliments") {

    slash("Compliment") {
        description = "get a compliment"
        execute(MemberArg) {
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

    command("Comp", "C") {
        description = "get a compliment"
        execute(UserArg("@username").optional { it.author }) {
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

