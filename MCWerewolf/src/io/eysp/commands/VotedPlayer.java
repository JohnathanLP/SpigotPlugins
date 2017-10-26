package io.eysp.commands;

import io.eysp.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VotedPlayer implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label , String[] args)
    {
        if (sender instanceof Player)
        {
            if(GameState.isPlayerAlive(args[0]))
            {
                Bukkit.broadcastMessage(String.format("%s has been sentenced to death", args[0]));
                Player p = (Player) sender;
                for(Player player:p.getWorld().getPlayers())
                {
                    if(player.getName().equals(args[0]))
                    {
                        player.setGameMode(GameMode.SPECTATOR);
                        //player.damage(100000);
                        // TODO - Actually kill the player - although technically this entire method is temporary...
                    }
                }
                GameState.StartNight();
            }
            else
            {
                sender.sendMessage("That player is not in the game, or is already dead!");
            }
        }
        
        return true;
    }
}
