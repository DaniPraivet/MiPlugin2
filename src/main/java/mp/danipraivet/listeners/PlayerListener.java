package mp.danipraivet.listeners;

import mp.danipraivet.MiPlugin2;
import mp.danipraivet.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

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
        // 0.5 75 0.5 spawn

        Player player = event.getPlayer();

        player.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&a Hola o/"));

        Location location = new Location(Bukkit.getWorld("spawn"), 0 , 77, 0, 90, 0); // Necesitamos que spawn sea un objeto tipo mundo

        player.teleport(location);
    }
}
