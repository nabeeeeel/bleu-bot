package me.nabeeeeel.bot.extensions

import com.gitlab.kordlib.core.entity.Message
import com.gitlab.kordlib.core.entity.ReactionEmoji
import com.gitlab.kordlib.kordx.emoji.DiscordEmoji
import com.gitlab.kordlib.kordx.emoji.toReaction

suspend fun Message.addReactions(vararg reactions: DiscordEmoji) { //
    reactions.forEach {
        addReaction(it.toReaction())
    }
}

suspend fun Message.addReactions(reactions: List<ReactionEmoji>) { //
    reactions.forEach {
        addReaction(it)
    }
}