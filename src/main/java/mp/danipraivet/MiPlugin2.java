package mp.danipraivet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MiPlugin2 extends JavaPlugin {


    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f MiPlugin2 ha sido iniciado"));
    }
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f MiPlugin2 ha sido desactivado"));
    }
}
