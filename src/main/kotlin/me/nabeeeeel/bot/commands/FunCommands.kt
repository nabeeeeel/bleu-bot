package me.nabeeeeel.bot.commands


import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.x.emoji.Emojis
import dev.kord.x.emoji.toReaction
import me.jakejmattson.discordkt.api.arguments.MultipleArg
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.commands.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.extensions.addReactions
import me.nabeeeeel.bot.services.ListService


// creates category
fun funCommands(configuration: Configuration, listService: ListService) = commands("Fun") {

    command("Punch") {
        description = "punch a user"
        execute(UserArg("@username")) {
            val user = args.first
            val author = author
            respond {
                description = "${author.tag} punched ${user.tag}"
                title = "P U N C H"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                image = listService.punches.random()
            }
        }
    }

    command("Hug") {
        description = "hug a user"
        execute(UserArg("@username")) {
            val user = args.first
            val author = author

            respond {
                description = "${author.tag} hugged ${user.tag}"
                title = "H U G"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                image =
                    listOf("https://media0.giphy.com/media/EvYHHSntaIl5m/giphy.gif?cid=ecf05e47hgm5fldt3ib7oc0t73qvif63wy2g3erl2fxe1bn0&rid=giphy.gif").random()
            }
        }
    }

    slash("BeeFact") {
        description = "Get a fact about Bees!"
        execute() {
            respond {
                title = ":bee: B E E :bee:"
                color = listOf(Color(222, 222, 0), Color(0, 0, 0)).random()
                description = listService.beeFacts.random()
            }
        }
    }

    command("Paella") {
        description =
            "Paella (pai·ei·uh) is a classic Spanish rice dish made with rice, saffron, vegetables, chicken, and seafood cooked and served in one pan."
        execute {
            respond {
                title = "P A E L L A"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                image = listService.paellas.random()
            }
        }
    }

    command("Crab") {
        description = ":crab:"
        execute {
            respond(":crab: ".repeat(100))
        }
    }

    command("Brr") {
        description = "bot go brr"
        execute(UserArg("@username").optional { it.author }) {
            respond("Bot go brrrr")
        }
    }

    command("Boo") {
        description = "BOOOOOOOOO"
        execute {
            val botMessage = channel.createMessage(Emojis.b.unicode + Emojis.o2.unicode.repeat(20))
            botMessage.addReactions(
                Emojis.ghost.toReaction(),
                Emojis.b.toReaction(),
                Emojis.o2.toReaction(),
                Emojis.o.toReaction()
            )
            message.addReaction(Emojis.ghost.toReaction())
        }
    }

    command("Whomst") {
        description = "Can't decide who to vote kick? Use this."
        execute(MultipleArg(UserArg("Users")).optional { listOf(it.author) }) {
            val userList = args.first.randomOrNull() ?: author
            respond("${userList.mention} is the imposter.")
        }
    }

    command("Jail") {
        description = "Is someone acting up? They may need to go to jail."
        execute(UserArg("User").optional { it.author }) {
            val user = args.first
            val botMessage = respond {
                title = ":rotating_light: G O  T O  H O R N Y  J A I L :rotating_light:"
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
                image =
                    "https://media1.tenor.com/images/6493bee2be7ae168a5ef7a68cf751868/tenor.gif?itemid=17298755"
                description = ":rotating_light: ${user.mention} is going to horny jail :rotating_light:"
            }
            TODO( "WAIT FOR JAKE")
//            botMessage.addReactions(
//                Emojis.rotatingLight.toReaction(),
//                Emojis.regionalIndicatorG.toReaction(),
//                Emojis.o2.toReaction(),
//                Emojis.regionalIndicatorT.toReaction(),
//                Emojis.regionalIndicatorO.toReaction(),
//                Emojis.regionalIndicatorJ.toReaction(),
//                Emojis.a.toReaction(),
//                Emojis.regionalIndicatorI.toReaction(),
//                Emojis.regionalIndicatorL.toReaction()
//            )
        }
    }

    command("Agis") {
        description = "Summons Agis from the Pits of Hell"
        execute {
            val botMessage = respond {
                val agis = discord.kord.getUser(Snowflake(219610743727718400))?.mention
                for (i in 1..15) {
                    message.channel.createMessage("$agis")
                }

            }
        }
    }
}