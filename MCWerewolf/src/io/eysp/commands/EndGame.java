package io.eysp.commands;

import io.eysp.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EndGame implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label , String[] args)
    {
        if (sender instanceof Player)
        {
            GameState.EndGame();
            // Bukkit.broadcastMessage("Game is starting!");
        }
        
        return true;
    }
}
