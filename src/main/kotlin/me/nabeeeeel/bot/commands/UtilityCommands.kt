package me.nabeeeeel.bot.commands

import dev.kord.common.Color
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.jakejmattson.discordkt.api.arguments.EveryArg
import me.jakejmattson.discordkt.api.arguments.MemberArg
import me.jakejmattson.discordkt.api.arguments.TimeArg
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.commands.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.services.ListService
import java.util.*
import kotlin.concurrent.schedule


// creates category
fun utilityCommands(configuration: Configuration, listService: ListService) = commands("Utility") {

    slash("Profile") {
        description = "Did someone make their Profile Picture for ants? Well here ya go!"
        execute(MemberArg("username")) {

            val user = args.first
            respond {
                // thumbnail { url = user.avatar.url }

                title = "P R O F I L E  P I C  for ${user.username}"
                image = user.avatar.url
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
            }
        }
    }

    slash("Timer") {
        description = "Remind you of something in a certain amount of minutes. The default is 5 minutes."
        execute(TimeArg, EveryArg) {
            val (time, message) = args
            respond("Starting timer for $time")
            Timer().schedule((time * 1000).toLong()) {
                GlobalScope.launch {
                    respond("${author.mention} $message")
                }
            }
        }
    }
}