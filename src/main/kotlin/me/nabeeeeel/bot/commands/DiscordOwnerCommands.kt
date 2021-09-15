package me.nabeeeeel.bot.commands

import dev.kord.x.emoji.Emojis
import dev.kord.x.emoji.toReaction
import me.jakejmattson.discordkt.api.arguments.AnyArg
import me.jakejmattson.discordkt.api.arguments.EveryArg
import me.jakejmattson.discordkt.api.commands.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.services.ListService
import me.nabeeeeel.bot.services.Permission


// creates category
fun discordOwnerCommands(configuration: Configuration, listService: ListService) = commands("Discord Owner") {

    // looks at configuration object, then set prefix field for the current guild(discord server)
    slash ("SetPrefix") {
        description = "Set the prefix required for the bot to register a command."
        requiredPermission = Permission.GUILD_OWNER
        execute(AnyArg("Prefix")) {
            val prefix = args.first
            //configuration.guildConfigurations[it.guild!!.idLong]?.prefix = prefix
            configuration[guild!!.id.value]?.prefix = prefix // replaces above code by overwriting
            configuration.save()
            respond("Prefix set to: $prefix")
        }
    }

    command("Thumbs") {
        description = "Display a question with :thumbsup: and :thumbsdown: as reactions"
        requiredPermission = Permission.GUILD_OWNER
        execute(EveryArg("Question")) {
            val question = args.first
            val botMessage = respond { description = question }
            //botMessage.addReactions(Emojis.thumbsup.toReaction(), Emojis.thumbsdown.toReaction())
            message.delete()
        }
    }
}