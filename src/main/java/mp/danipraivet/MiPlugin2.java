package mp.danipraivet;

import mp.danipraivet.commands.MainCommand;
import mp.danipraivet.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MiPlugin2 extends JavaPlugin {

    public static String prefix = "&8[&c&lMiPlugin²&8] ";

    private final String version = getDescription().getVersion();

    @Override
    public void onEnable() {

        registerCommands();

        registerEvents();

        String version = "(v" + getDescription().getVersion() + ")";

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "ha sido iniciado. &fVersion: " + version));
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "&e Gracias por usar mi plugin :>"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "ha sido detenido. &fVersion: " + version));
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "&e Gracias por usar mi plugin :>"));
    }

    public void registerCommands(){
        this.getCommand("miplugin").setExecutor(new MainCommand(this));
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
    }

}
