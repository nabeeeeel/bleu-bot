package me.nabeeeeel.bot.listeners


import dev.kord.common.entity.Snowflake
import dev.kord.core.event.message.MessageCreateEvent
import me.jakejmattson.discordkt.api.Discord
import me.jakejmattson.discordkt.api.dsl.listeners
import me.nabeeeeel.bot.services.ListService


fun mentionListener(listService: ListService, discord: Discord) = listeners {
    on<MessageCreateEvent> {
        val content = message.content

        if (content.contains("nick fight me", true)) {
            val nick = discord.kord.getUser(Snowflake(193228408895963136))?.mention

            message.channel.createMessage("$nick fite me, you evil man!")
        }
//        } else if (content.contains("fight me nick", true)) {
//            val nick = discord.api.getUser(Snowflake(193228408895963136))?.mention
//
//            message.channel.createMessage("$nick fite me, you evil man!")
//        }
//
//        if (content.contains("Queen of the internet", true)) {
//            val jenny = discord.api.getUser(Snowflake(160571470295203840))?.mention
//
//            message.channel.createMessage("All hail $jenny, the Internet's One True Queen")
//        } else if (content.contains("The Queen", true)) { // cameron's discord id: 381186310163005443
//            val jenny = discord.api.getUser(Snowflake(160571470295203840))?.mention
//
//            message.channel.createMessage("All hail $jenny, the Internet's One True Queen")
//        }
        if (content.contains("ayy", true)) {
            message.channel.createMessage("lmao")
        }

        if (content.contains("good bot", true)) {
            message.channel.createMessage(":)")
        }

        if (content.contains("bad bot", true)) {
            message.channel.createMessage(":(")
        }
    }
}