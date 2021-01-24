package me.nabeeeeel.bot.services

import com.gitlab.kordlib.common.entity.Snowflake
import com.gitlab.kordlib.core.entity.Message
import com.gitlab.kordlib.kordx.emoji.Emojis
import com.gitlab.kordlib.kordx.emoji.toReaction
import me.jakejmattson.discordkt.api.annotations.Service

@Service
class PollService {

    val pollEmojis = mutableMapOf(
            Emojis.one.toReaction() to 0,
            Emojis.two.toReaction() to 0,
            Emojis.three.toReaction() to 0,
            Emojis.four.toReaction() to 0,
            Emojis.five.toReaction() to 0,
            Emojis.six.toReaction() to 0,
            Emojis.seven.toReaction() to 0,
            Emojis.eight.toReaction() to 0,
            Emojis.nine.toReaction() to 0,
            Emojis.zero.toReaction() to 0
    )

    val voteEmojiList = listOf(
            Emojis.one.toReaction(),
            Emojis.two.toReaction(),
            Emojis.three.toReaction(),
            Emojis.four.toReaction(),
            Emojis.five.toReaction(),
            Emojis.six.toReaction(),
            Emojis.seven.toReaction(),
            Emojis.eight.toReaction(),
            Emojis.nine.toReaction(),
            Emojis.zero.toReaction()
    )

    var pollMessageId = mutableListOf<Snowflake>()

    var polls = mutableMapOf(Snowflake(758983158418112523) to pollEmojis)

    fun getPolls (message : Message) = polls[message.id]
}