package me.nabeeeeel.bot.commands


import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.edit
import dev.kord.rest.builder.message.modify.embed
import me.jakejmattson.discordkt.api.arguments.EveryArg
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.commands.commands
import me.jakejmattson.discordkt.api.extensions.addField
import me.nabeeeeel.bot.services.ListService
import me.nabeeeeel.bot.services.Permission
import me.nabeeeeel.bot.services.RoleService
import kotlin.system.exitProcess
import me.jakejmattson.discordkt.api.extensions.addReactions


// creates category
fun botOwnerCommands(
    roleService: RoleService,
    listService: ListService
) = commands("Bot Owner") {

    command("Kill") {
        description = "Kill the bot. It will remember this decision."
        requiredPermission = Permission.BOT_OWNER
        execute {
            respond {
                description =
                    "But I loved you all..."
                title = "G O O D  B Y E"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                image =
                    listOf("https://media1.tenor.com/images/d3ab6e1d6375d41d846a90b5076c617d/tenor.gif?itemid=5280826").random()
            }
            exitProcess(0)
        }
    }

    // TODO: add file to store the bee facts
    command("AddBeeFact") {
        requiredPermission = Permission.BOT_OWNER
        description = "Add a Bee fact."
        execute(EveryArg("Fact")) {
            listService.beeFacts.add(args.first)
        }
    }

    command("CreateRolesMessage") {
        description = "create roles message"
        requiredPermission = Permission.BOT_OWNER
        execute {
            val games = roleService.getGames(guild) ?: return@execute
            val roles = games.map { "${it.key.mention}\t ${guild.getRole(it.value).mention}" }.joinToString("\n")

            val botMessage = respond {
                // thumbnail { url = user.avatar.url }
                title = "R O L E S"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                description = "React with the corresponding reaction for the role you want!"
                addField("", roles)
            }

            botMessage?.addReactions(games.map { it.key })
        }
    }

    command("EditRolesMessage") {
        description = "edits roles message"
        requiredPermission = Permission.BOT_OWNER
        execute {
            val games = roleService.getGames(guild) ?: return@execute
            val roles = games.map { "${it.key.mention}\t ${guild.getRole(it.value).mention}" }.joinToString("\n")

            val message = channel.getMessage(Snowflake("757486167569727528"))

            message.edit {
                embed {
                    title = "R O L E S"
                    color = Color((0..255).random(), (0..255).random(), (0..255).random())
                    description = "React with the corresponding reaction for the role you want!"
                    addField("", roles)
                }
            }
        }
    }

    command("monki") {
        description = "gives monki"
        execute(UserArg("@username").optional { it.author }) {
            val monkiTarget = args.first
            monkiTarget.asMember(Snowflake(753132775040614421)).addRole(Snowflake(753135012202938380))
        }
    }
}
