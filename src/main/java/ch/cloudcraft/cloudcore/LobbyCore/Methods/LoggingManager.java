package ch.cloudcraft.cloudcore.LobbyCore.Methods;

import org.bukkit.entity.Player;
import org.json.simple.JSONObject;

public class LoggingManager {

    public static void logAction(Player p, String action, boolean success, String server, String actionMessage) {

        JSONObject jsonObject = new JSONObject();

        JSONObject userObject = new JSONObject();
        userObject.put("username", p.getName());
        userObject.put("uuid", p.getUniqueId());

        jsonObject.put("user", userObject);

        JSONObject actionObject = new JSONObject();
        actionObject.put("type", action);
        actionObject.put("succeeded", success);
        actionObject.put("server", server);
        actionObject.put("actionmessage", actionMessage);

        jsonObject.put("action", actionObject);

        Runnable runnable = new AsyncHttpRequest("http://45.88.108.166:8000/LoggingWebhook", jsonObject);
        Thread executorThread = new Thread(runnable);
        executorThread.start();


    }


}
