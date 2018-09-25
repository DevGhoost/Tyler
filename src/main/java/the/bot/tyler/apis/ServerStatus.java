package the.bot.tyler.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ServerStatus {

    private String numeric;
    private BufferedReader bf;

    public ServerStatus(String ip) {
        this.numeric = new MinecraftAPI().getServerNumericIP(ip);
        try {
            URL url = new URL("https://mcapi.xdefcon.com/server/" + this.numeric + "/full/json");
            this.bf = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] getSpacers() {
        String[] spacers = null;
        try {
            spacers =  bf.readLine().split("\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
            return spacers;
    }

    public String getPlayers() {
        return this.getSpacers()[17] + "/" + this.getSpacers()[19];
    }


}
