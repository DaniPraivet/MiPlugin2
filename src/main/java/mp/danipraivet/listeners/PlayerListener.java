package mp.danipraivet.listeners;

import mp.danipraivet.MiPlugin2;
import mp.danipraivet.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message= event.getMessage();

        if (message.toLowerCase().contains("tonimatasmc")){ // Palabra prohibida
            event.setCancelled(true); // No se envía el mensaje
            player.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&cSe escribe TonimatasDEV cara huevo."));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // 0.5 77 0.5 spawn

        Player player = event.getPlayer();

        player.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&a Hola o/"));

        Location location = new Location(Bukkit.getWorld("world"), 0 , 77, 0, 90, 0); // world es el nombre en un server paper

        player.teleport(location);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(player.getWorld().getName().equals("spawn") && !player.hasPermission("miplugin.admin")){ // Nos inventamos un permiso
            event.setCancelled(true);
            player.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&cNo puedes romper bloques en el aquí"));
        }
    }

}
