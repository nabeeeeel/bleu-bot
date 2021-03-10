package me.nabeeeeel.bot.listeners


import dev.kord.common.entity.Snowflake
import dev.kord.core.event.message.ReactionAddEvent
import dev.kord.core.event.message.ReactionRemoveEvent
import me.jakejmattson.discordkt.api.Discord
import me.jakejmattson.discordkt.api.dsl.listeners
import me.nabeeeeel.bot.services.PollService
import me.nabeeeeel.bot.services.RoleService


fun reactionListener(discord: Discord, roleService: RoleService, pollService: PollService) = listeners {
    on<ReactionAddEvent> {
        val games = guild?.asGuild()?.let { roleService.getGames(it) } ?: return@on

        if (messageId == Snowflake(757486167569727528)) {
            games[emoji]?.let { userAsMember!!.addRole(it) }
        }
    }

    on<ReactionRemoveEvent> {
        val games = guild?.asGuild()?.let { roleService.getGames(it) } ?: return@on

        if (messageId == Snowflake(757486167569727528)) {
            games[emoji]?.let { userAsMember!!.removeRole(it) }
        }
    }
}