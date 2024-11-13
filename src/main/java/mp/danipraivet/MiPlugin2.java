package mp.danipraivet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MiPlugin2 extends JavaPlugin {

    public String prefix = "&8[&c&lMiPlugin²&8] ";

    private String version = getDescription().getVersion();

    @Override
    public void onEnable() {
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
}
