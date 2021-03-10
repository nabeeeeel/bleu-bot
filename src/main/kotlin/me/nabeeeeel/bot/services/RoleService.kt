package me.nabeeeeel.bot.services


import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Guild
import dev.kord.core.entity.ReactionEmoji
import dev.kord.x.emoji.Emojis
import dev.kord.x.emoji.toReaction
import me.jakejmattson.discordkt.api.annotations.Service

@Service
/**
 * Anything
 * @property gameRoles A map of the roles to the emojis
 */
class RoleService {
    private val gameRoles = mutableMapOf(
            Snowflake("216738349979926531") to mapOf<ReactionEmoji, Snowflake>(
                    Emojis.knife.toReaction() to Snowflake("741849415597293619"),
                    Emojis.parachute.toReaction() to Snowflake("741849545872244806"),
                    Emojis.salt.toReaction() to Snowflake("741849803939643513"),
                    Emojis.spaceInvader.toReaction() to Snowflake("741849725740908584")
            )
    )

    fun getGames(guild: Guild) = gameRoles[guild.id]


}