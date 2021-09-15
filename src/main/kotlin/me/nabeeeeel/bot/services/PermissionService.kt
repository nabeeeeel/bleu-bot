package me.nabeeeeel.bot.services


import me.jakejmattson.discordkt.api.dsl.PermissionContext
import me.jakejmattson.discordkt.api.dsl.PermissionSet
import me.nabeeeeel.bot.data.Configuration


enum class Permission : PermissionSet {
    BOT_OWNER {
        override suspend fun hasPermission(context: PermissionContext): Boolean {
            val configuration = context.discord.getInjectionObjects<Configuration>()
            return context.getMember()?.id?.value == configuration.botOwner
        }
    },
    GUILD_OWNER {
        override suspend fun hasPermission(context: PermissionContext): Boolean {
            return context.getMember()?.isOwner() ?: false
        }
    },
    USER {
        override suspend fun hasPermission(context: PermissionContext): Boolean {
            return true
        }
    }
}