package the.bot.tyler.commands.minecraft;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import the.bot.tyler.Launcher;
import the.bot.tyler.apis.MinecraftAPI;

import java.awt.*;

public class McServerStatus extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Launcher.prefix + "serverstatus")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("<:tnt:493944495554166795> **|** " + args[1]);
            embed.setColor(Color.ORANGE);
            embed.setImage(new MinecraftAPI().getServerIconUrl(args[1]));
            embed.addField("Players", new the.bot.tyler.apis.ServerStatus(args[1]).getPlayers(), false);
            event.getChannel().sendMessage(event.getAuthor().getAsMention()).queue();
            event.getChannel().sendMessage(embed.build()).queue();
        } else if (args[0].equalsIgnoreCase(Launcher.prefix + "ip")) {
            event.getChannel().sendMessage(new MinecraftAPI().getServerNumericIP(args[1])).queue();
        }
    }
}
