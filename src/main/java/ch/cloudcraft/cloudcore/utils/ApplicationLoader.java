package ch.cloudcraft.cloudcore.utils;

import ch.cloudcraft.cloudcore.Main;


public class ApplicationLoader {
    public static Application application;

    public static void resolve() {
        Main.getPlugin().reloadConfig();

        application = (Application) Main.getPlugin().getConfig().get("Application");
    }

    public enum Application {
        LOBBY,
        OTHER
    }
}
