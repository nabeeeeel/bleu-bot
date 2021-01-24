package me.nabeeeeel.bot.commands

import com.gitlab.kordlib.kordx.emoji.Emojis
import me.jakejmattson.discordkt.api.arguments.AnyArg
import me.jakejmattson.discordkt.api.arguments.EveryArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.extensions.addReactions
import me.nabeeeeel.bot.extensions.requiredPermissionLevel
import me.nabeeeeel.bot.services.ListService
import me.nabeeeeel.bot.services.Permission


// creates category
fun discordOwnerCommands(configuration: Configuration, listService: ListService) = commands("Discord Owner") {

    // looks at configuration object, then set prefix field for the current guild(discord server)
    command("SetPrefix") {
        description = "Set the prefix required for the bot to register a command."
        requiredPermissionLevel = Permission.GUILD_OWNER
        execute(AnyArg("Prefix")) {
            val prefix = args.first
            //configuration.guildConfigurations[it.guild!!.idLong]?.prefix = prefix
            configuration[guild!!.id.longValue]?.prefix = prefix // replaces above code by overwriting
            configuration.save()
            respond("Prefix set to: $prefix")
        }
    }

    command("Thumbs") {
        description = "Display a question with :thumbsup: and :thumbsdown: as reactions"
        requiredPermissionLevel = Permission.GUILD_OWNER
        execute(EveryArg("Question")) {
            val question = args.first
            val botMessage = respond { description = question}
            botMessage.addReactions(Emojis.thumbsup, Emojis.thumbsdown)
            message.delete()
        }
    }
}