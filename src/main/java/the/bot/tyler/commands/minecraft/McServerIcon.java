package the.bot.tyler.commands.minecraft;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import the.bot.tyler.Launcher;
import the.bot.tyler.apis.MinecraftAPI;

import java.awt.*;

public class McServerIcon extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Launcher.prefix + "servericon")) {
            if (args.lenght = 2) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("<:tnt:493944495554166795> **|** " + args[1]);
                embed.setColor(Color.ORANGE);
                embed.setImage(new MinecraftAPI().getServerIconUrl(args[1]));
                event.getChannel().sendMessage(event.getAuthor().getAsMention()).queue();
                event.getChannel().sendMessage(embed.build()).queue();
            } else {
                   event.getChannel().sendMessage(event.getAuthor().getAsMention() + " **|** Digite um ip!").queue();
            }
        }
    }
}
