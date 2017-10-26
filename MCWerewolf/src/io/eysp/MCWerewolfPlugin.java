package io.eysp;

import io.eysp.commands.EndGame;
import io.eysp.commands.StartGame;
import io.eysp.commands.VotedPlayer;
import io.eysp.listeners.MonsterKillListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MCWerewolfPlugin extends JavaPlugin
{  
    @Override
    public void onEnable()
    {
        // set command executors
        this.getCommand("startGame").setExecutor(new StartGame());
        this.getCommand("endGame").setExecutor(new EndGame());
        this.getCommand("votedPlayer").setExecutor(new VotedPlayer());
        
        //register listeners
        getServer().getPluginManager().registerEvents(new MonsterKillListener(), this);
    }
    
    @Override
    public void onDisable()
    {
        
    }
}
