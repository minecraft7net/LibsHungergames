package me.libraryaddict.Hungergames.Commands;

import me.libraryaddict.Hungergames.Managers.TranslationManager;
import me.libraryaddict.Hungergames.Managers.PlayerManager;
import me.libraryaddict.Hungergames.Types.HungergamesApi;
import me.libraryaddict.Hungergames.Types.Gamer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    private TranslationManager cm = HungergamesApi.getTranslationManager();
    public String description = "If spectating you can teleport back to spawn";
    private PlayerManager pm = HungergamesApi.getPlayerManager();
    public String[] aliases = new String[] { "hgspawn" };

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Gamer gamer = pm.getGamer(sender.getName());
        if (!gamer.isAlive()) {
            pm.sendToSpawn(gamer);
            return true;
        } else {
            ((Player) sender).setCompassTarget(HungergamesApi.getHungergames().world.getSpawnLocation());
            gamer.getPlayer().sendMessage(cm.getCommandSpawnPointingToSpawn());
        }
        return true;
    }

}
