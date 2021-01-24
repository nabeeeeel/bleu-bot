package me.nabeeeeel.bot.listeners

import com.gitlab.kordlib.common.entity.Snowflake
import com.gitlab.kordlib.core.event.message.ReactionAddEvent
import com.gitlab.kordlib.core.event.message.ReactionRemoveEvent
import me.jakejmattson.discordkt.api.Discord
import me.jakejmattson.discordkt.api.dsl.listeners
import me.nabeeeeel.bot.services.PollService
import me.nabeeeeel.bot.services.RoleService


fun reactionListener(discord: Discord, roleService: RoleService, pollService: PollService) = listeners {
    on<ReactionAddEvent> {
        val games = guild?.asGuild()?.let { roleService.getGames(it) } ?: return@on
        val poll = message.asMessage().let {pollService.getPolls(it)} ?: return@on

        if (messageId == Snowflake(757486167569727528)) {
            games[emoji]?.let { userAsMember!!.addRole(it) }
        }

        if (messageId == pollService.pollMessageId[0]) {
            poll[emoji]?.let {
              //  pollService.polls[messageId]?.set(mapOf(emoji  to it++))
            }
        }
    }

    on<ReactionRemoveEvent> {
        val games = guild?.asGuild()?.let { roleService.getGames(it) } ?: return@on

        if (messageId == Snowflake(757486167569727528)) {
            games[emoji]?.let { userAsMember!!.removeRole(it) }
        }
    }
}