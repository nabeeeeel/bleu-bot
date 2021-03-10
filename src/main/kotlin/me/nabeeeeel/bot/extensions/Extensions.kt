package me.nabeeeeel.bot.extensions

import dev.kord.common.entity.DiscordEmoji
import dev.kord.core.entity.Message
import dev.kord.core.entity.ReactionEmoji
import dev.kord.x.emoji.toReaction
import dev.kord.x.emoji.Emojis

suspend fun Message.addReactions(vararg reactions: ReactionEmoji) { //
    reactions.forEach {
        addReaction(it)
    }
}

suspend fun Message.addReactions(reactions: List<ReactionEmoji>) { //
    reactions.forEach {
        addReaction(it)
    }
}