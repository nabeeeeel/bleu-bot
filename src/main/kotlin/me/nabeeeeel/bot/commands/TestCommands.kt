package me.nabeeeeel.bot.commands


import dev.kord.common.Color
import dev.kord.x.emoji.Emojis
import dev.kord.x.emoji.toReaction
import me.jakejmattson.discordkt.api.arguments.SplitterArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.jakejmattson.discordkt.api.extensions.toTimeString
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.extensions.requiredPermissionLevel
import me.nabeeeeel.bot.services.ListService
import me.nabeeeeel.bot.services.Permission
import me.nabeeeeel.bot.services.PollService
import java.util.*

val startDate = Date()


// creates category
fun testCommands(configuration: Configuration, listService: ListService, pollService: PollService) = commands("Testing") {


    command("Ping", "Uptime") {
        description = "a test command to make sure the bot is working"
        execute {
            respond {
                color = discord.configuration.theme as Color
                val seconds = Date().time - startDate.time
                field {
                    name = "Total Uptime"
                    value = seconds.toTimeString(true)
                    inline = true
                }
            }
        }
    }

    // TODO: grab messageID then add a listener to it that will edit the message with the reaction count next to it. Then reorder the items based on the reaction count
    command("Poll") {
        // TODO add to DiscordOwnerCommands after finished.
        requiredPermissionLevel = Permission.BOT_OWNER
        description = "Create a poll. Item Limit: 10"
        execute(SplitterArg("Poll Title | Item1 | Item2 | ... | Item10")) {
            val pollList = args.first
            if (pollList.size > 11) {
                respond {
                    field {
                        name = "E R R O R"
                        value = "Only 10 poll items are allowed. :("
                    }
                }
                return@execute
            }
            val username = author.username
            val avatar = author.avatar.url
            val botMessage = respondMenu {
                page {
                    title = ":pencil:  P O L L : ${pollList[0].toUpperCase()} :pencil:"
                    author {
                        name = username
                        icon = avatar
                    }

                    // list split by |
                    pollList.drop(1).forEachIndexed { count: Int, option: String ->
                        field { name = "${pollService.voteEmojiList[count]} $option" }
                    }
                }
            }
            var newMap = mutableMapOf(Emojis.one.toReaction() to 0)
            pollList.drop(1).forEachIndexed { count, option ->
                botMessage!!.addReaction(pollService.voteEmojiList[count])
                newMap[pollService.voteEmojiList[count]] = 0
            }
            val messageID = botMessage!!.id

            pollService.pollMessageId.add(messageID)
            pollService.polls[messageID] = newMap

            //respond("${pollService.polls[messageID]}")

        }
    }

//    command("Talk") {
//        description = "talk to the bot!"
//        execute() {
//            conversationService.startPublicConversation<TestConversation>(author.asUser(), channel.asChannel())
//        }
//    }
    // TODO: YIKES command, Math commands (calculus, binary to dec, dec to bin, dec to hex, hex to bin, etc),
}