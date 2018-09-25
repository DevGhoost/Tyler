package the.bot.tyler.commands.minecraft;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import the.bot.tyler.Launcher;
import the.bot.tyler.apis.MinecraftAPI;

import java.awt.*;

public class McHead extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Launcher.prefix + "head")) {

                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("<:tnt:493944495554166795> **|** Cabeça de " + args[1]);
                embed.setColor(Color.ORANGE);
                embed.setImage(new MinecraftAPI().getHeadUrl(args[1]));
                event.getChannel().sendMessage(event.getAuthor().getAsMention()).queue();
                event.getChannel().sendMessage(embed.build()).queue();

            }

        }

}
