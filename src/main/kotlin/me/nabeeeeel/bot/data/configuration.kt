package me.nabeeeeel.bot.data

import me.jakejmattson.discordkt.api.dsl.Data


data class Configuration(
    val botOwner: Long = 125991444212088832,
    val guildConfigurations: MutableMap<Long, GuildConfiguration> = mutableMapOf()
) : Data("config/config.json") // kill if generated will kill bot
{
    operator fun get(id: Long) = guildConfigurations[id]
    operator fun set(idLong: Long, value: GuildConfiguration) {
        guildConfigurations[idLong] = value
    }
}

data class GuildConfiguration(var prefix: String)