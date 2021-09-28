package de.zettos.flyplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FlyPlugin extends JavaPlugin implements Core{

    @Override
    public void setFly(CommandSender sender, Player player, String prefix) {

        if(player == null){
            sender.sendMessage(prefix+"§cDieser Spieler ist nicht Online");
            return;
        }
        if(player.getAllowFlight()){
            player.setAllowFlight(false);
            sender.sendMessage(prefix+"Der Spieler "+player.getName()+" kann nun nichtmehr Fliegen!");
        }else{
            player.setAllowFlight(true);
            sender.sendMessage(prefix+"Der Spieler "+player.getName()+" kann nun Fliegen!");
        }
    }

    private Core core;
    private String pr;

    @Override
    public void onLoad() {
        this.core = this;
        this.pr = "§8[§cFly§8] §7";
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(pr+"Plugin erfolgreich §aAktiviert!");
        Objects.requireNonNull(getCommand("fly")).setExecutor(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(pr+"Plugin erfolgreich §cDeaktiviert!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage(this.pr+"§cDu musst ein Spieler sein, um diesen Befehl ausfuehren zu koennen!");
                return true;
            }
            Player p = (Player) sender;
            this.core.setFly(sender,p,this.pr);
            return true;
        }else if(args.length == 1){
            Player player = Bukkit.getPlayer(args[0]);
            this.core.setFly(sender,player,this.pr);
            return true;
        }else{
            sender.sendMessage(this.pr+"§cBenutze: /fly <Player>");
            return true;
        }


    }
}
