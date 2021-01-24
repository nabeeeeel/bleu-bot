//package me.nabeeeeel.bot.conversations
//
//import me.jakejmattson.discordkt.api.arguments.AnyArg
//import me.jakejmattson.discordkt.api.arguments.IntegerArg
//import me.jakejmattson.discordkt.api.dsl.Conversation
//import me.jakejmattson.discordkt.api.dsl.conversation
//
//class TestConversation() : Conversation() {
//    @Start
//    fun start() = conversation {
//        val name = promptMessage(AnyArg, "What is your name?")
//        val favNum = promptMessage(IntegerArg, "What is your favorite number?")
//
//        if (favNum >= 26)
//            respond("$name, hello")
//        else
//            respond("Thanks for the talk, $name!")
//    }
//}