package the.bot.tyler.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MinecraftAPI {

    private BufferedReader in;
    private String[] spaces;
    public String getUUID(String name) {
        URL url = null;
        try {
            url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
          in = new BufferedReader(new InputStreamReader(url.openStream()));
          spaces = in.readLine().split("\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.spaces[3];
    }

    public String getHeadUrl(String name) {
       return "https://crafatar.com/avatars/" + getUUID(name)+ "?size=140&overlay";
    }

    public String getServerIconUrl(String ip) {
        return "https://eu.mc-api.net/v3/server/favicon/" + ip;
    }


    public String getServerNumericIP(String ip) {
        URL url = null;
        BufferedReader ipe = null;
        String[] lines = null;
        try {
            url = new URL("https://api.mcsrvstat.us/1/" + ip);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            ipe = new BufferedReader(new InputStreamReader(url.openStream()));
            lines = ipe.readLine().split("\"");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines[3];
    }

}
