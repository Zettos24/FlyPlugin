package de.zettos.flyplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FlyPlugin extends JavaPlugin {

    private static final String PREFIX = "§8[§cFly§8] §7";

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target;

        if(args.length == 0) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(PREFIX + "§cIn der Konsole muss ein Spieler angegeben werden.");
                return true;
            }

            target = (Player) sender;
        } else {
            target = Bukkit.getPlayer(args[0]);

            if(target == null) {
                sender.sendMessage(PREFIX + "§cDieser Spieler ist nicht online!");
                return true;
            }
        }

        target.setAllowFlight(!target.getAllowFlight());
        sender.sendMessage(PREFIX + "§e" + target.getName() + " §7kann nun " + (!target.getAllowFlight() ? "nicht mehr " : "") + "fliegen!");
        return true;
    }

}