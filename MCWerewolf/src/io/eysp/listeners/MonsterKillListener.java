package io.eysp.listeners;

import io.eysp.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MonsterKillListener implements Listener
{
    @EventHandler
    public void onKill(EntityDeathEvent event)
    {
        if(event.getEntity().getType() == EntityType.PLAYER)
        {
            if(event.getEntity().getKiller() == GameState.getMonster())
            {
                Bukkit.broadcastMessage("Player was killed by monster");
                GameState.EndNight();
            }
            else
            {
                Bukkit.broadcastMessage("Player was killed by another player");
            }
        }
    }
}
