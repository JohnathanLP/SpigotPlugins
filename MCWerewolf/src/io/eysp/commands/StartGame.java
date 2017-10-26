package io.eysp.commands;

import io.eysp.GameState;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartGame implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label , String[] args)
    {
        if (sender instanceof Player)
        {
            GameState.StartGame(sender);
        }
        
        return true;
    }
}
