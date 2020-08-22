package ch.cloudcraft.cloudcore.LobbyCore.Methods;


import ch.cloudcraft.cloudcore.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

public class BungeeWrapper {

    public static void sendPlayerTo(Player p, String playername, String Server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("ConnectOther");
        out.writeUTF(playername);
        out.writeUTF(Server);

        // If you don't care about the player
        // Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
        // Else, specify them

        p.sendPluginMessage(Main.getPlugin(), "BungeeCord", out.toByteArray());
    }
}
