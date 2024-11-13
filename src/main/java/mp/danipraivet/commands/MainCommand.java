package mp.danipraivet.commands;

import mp.danipraivet.MiPlugin2;
import mp.danipraivet.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCommand implements CommandExecutor {

    private MiPlugin2 plugin;

    public MainCommand(MiPlugin2 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        if(!(sender instanceof Player)){
            // Consola
            sender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&' , MiPlugin2.prefix +"&cSolamente puedes usar este comando si eres un jugador"));
            return true;
        }

        // Jugador
        Player player = (Player) sender;



        // /miplugin args[0] args[1] args[2]
        if ( args.length >= 1 ) {
            if (args[0].equalsIgnoreCase("bienvenida")) {
                // /miplugin bienvenida
                sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix+"&7Bienvenido &a"+player.getName()));
            }
            else if (args[0].equalsIgnoreCase("fecha")) {
                // /miplugin fecha
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = dateFormat.format(new Date());
                sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix+"&7Fecha y hora actual: &e"+date));
            }
            else if (args[0].equalsIgnoreCase("get")){
                // /miplugin get <author/version>
                subCommandGet(sender, args);
            }
            else{

            }
        }
        else {
            // /miplugin
            help(sender);
        }

        return true;
        // Mensaje de error
    }
    public void help(CommandSender sender){
        sender.sendMessage(MessageUtils.getColoredMessage("&f&l----------COMANDOS &c&lMIPLUGIN&b&l2&f&l----------"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7- /miplugin bienvenida"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7- /miplugin fecha"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7- /miplugin get"));
        sender.sendMessage(MessageUtils.getColoredMessage("&f&l----------COMANDOS &c&lMIPLUGIN&b&l2&f&l----------"));
    }

    public void subCommandGet(CommandSender sender, String[] args) {

        if(!sender.hasPermission("miplugin.commands.get")){
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&cNo tienes permisos para usar este comando."));
            return;
        }

        if (args.length == 1){
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&cDebes usar &7/miplugin get <autor/version"));
            return;
        }
        if (args[1].equalsIgnoreCase("autor")){
            // /miplugin get autor
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MiPlugin2.prefix+"&7Los autores del plugin son: &e"+plugin.getDescription().getAuthors()));
        }
        else if (args[1].equalsIgnoreCase("version")){
            // /miplugin get version
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MiPlugin2.prefix+"&7La version del plugin es: &e"+plugin.getDescription().getVersion()));
        }else {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin2.prefix +"&cDebes usar &7/miplugin get <autor/version"));
        }



    }
}
