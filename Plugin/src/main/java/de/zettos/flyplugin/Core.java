package de.zettos.flyplugin;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface Core {

    void setFly(CommandSender sender, Player player, String prefix);

}
