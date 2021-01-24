package me.nabeeeeel.bot.services

import com.gitlab.kordlib.core.entity.Member
import me.jakejmattson.discordkt.api.annotations.Service
import me.nabeeeeel.bot.data.Configuration


enum class Permission {
    BOT_OWNER,
    GUILD_OWNER,
    USER
}

val DEFAULT_REQUIRED_PERMISSION = Permission.USER

@Service
class PermissionsService(private val configuration: Configuration) {
    suspend fun hasClearance(member: Member, requiredPermissionLevel: Permission) = member.getPermissionLevel().ordinal <= requiredPermissionLevel.ordinal

    private suspend fun Member.getPermissionLevel() =
            when {
                isBotOwner() -> Permission.BOT_OWNER
                isGuildOwner() -> Permission.GUILD_OWNER
                else -> Permission.USER
            }

    private fun Member.isBotOwner() = id.longValue == configuration.botOwner
    private suspend fun Member.isGuildOwner() = isOwner()
}