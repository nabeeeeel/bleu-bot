package me.nabeeeeel.bot.listeners

import dev.kord.common.entity.Snowflake
import dev.kord.core.event.guild.MemberJoinEvent
import me.jakejmattson.discordkt.api.Discord
import me.jakejmattson.discordkt.api.dsl.listeners

// TODO: add auto create map when added to a new server
// GUILD TO ROLE
val guildMaps = mapOf(
    Snowflake(216738349979926531) to Snowflake(227292082996379648), // bleu's cleus
    Snowflake(702499793334960129) to Snowflake(702541515469357208), // Thieves Guild
    Snowflake(753132775040614421) to Snowflake(753135012202938380), // Monki Monki
    Snowflake(492784031163744277) to Snowflake(492867921186521089) // Mouth Breathers
)

fun joinListener(discord: Discord) = listeners {

    on<MemberJoinEvent> {
        // elvis operator, if L is null, execute right side
        val role = guildMaps[guild.id] ?: return@on
        member.addRole(role)
    }
}