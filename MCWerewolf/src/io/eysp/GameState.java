package io.eysp;

import java.util.List;
import org.bukkit.Bukkit;
import static org.bukkit.Material.LEATHER_BOOTS;
import static org.bukkit.Material.LEATHER_CHESTPLATE;
import static org.bukkit.Material.LEATHER_LEGGINGS;
import static org.bukkit.Material.SKULL_ITEM;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import static org.bukkit.potion.PotionEffectType.INCREASE_DAMAGE;
import static org.bukkit.potion.PotionEffectType.JUMP;
import static org.bukkit.potion.PotionEffectType.NIGHT_VISION;
import static org.bukkit.potion.PotionEffectType.SPEED;

public enum GameState 
{
    INACTIVE, DAY, NIGHT;
    
    private static boolean inProgress = false;
    private static List<Player> playerList;
    private static int playerCount = 0;
    private static Player monster;
    
    /**
     * Temporary fix. Indicates the current stage of gameplay
     * night1 - Night has begun, monster has not yet killed
     * night2 - Monster has killed, night has not ended.
     * day1 - Day has begun, vote has not yet been made
     * day2 - Vote has been made, night has not yet begun
     */
    private static String stage;
    
    public static boolean StartGame(CommandSender sender)
    {
        if(!inProgress)
        {
            Bukkit.broadcastMessage("Game is now Starting!");
            stage = "night1";
            inProgress = true;
            // Get player list
            Player p = (Player) sender;
            playerList = p.getWorld().getPlayers();
            playerCount = playerList.size();
            Bukkit.broadcastMessage(String.format("Current Player Count: %s", playerCount));
            
            // Set approprate world settings
            p.getWorld().setGameRuleValue("doMobSpawning", "false");
            p.getWorld().setGameRuleValue("announceAdvancements", "false");
            p.getWorld().setGameRuleValue("showDeathMessages", "false");
            p.getWorld().setGameRuleValue("naturalRegeneration", "false");
            
            // Select monster
            int temp = (int) (Math.random() * playerList.size());
            monster = playerList.get(temp);
            //Bukkit.broadcastMessage(String.format("Monster is %s", monster.getName()));
            
            // Start the night
            StartNight();
            
            return true;
        }
        else
        {
            Bukkit.broadcastMessage("Game is already in progress...");
            return false;
        }
    }
    
    public static void EndGame()
    {
        if(inProgress)
        {
            Bukkit.broadcastMessage("Game is now over!");
            inProgress = false;
            
            // Set approprate world settings
            monster.getWorld().setGameRuleValue("announceAdvancements", "true");
            monster.getWorld().setGameRuleValue("showDeathMessages", "true");
            monster.getWorld().setGameRuleValue("naturalRegeneration", "false");
            
            EndNight();
            //return true;
        }
        else
        {
            Bukkit.broadcastMessage("No game is in progress...");
            //return false;
        }
    }
    
    public static void StartNight()
    {
        for(Player player:playerList)
        {
            if (player.equals(monster))
            {
                player.sendTitle("You are the monster", "Prepare to hunt", 30, 50, 30);
            }
            else
            {
                player.sendTitle("You are a villager", "Hide or run", 30, 50, 30);
            }
        }
        monster.getWorld().setTime(15000);
        monster.addPotionEffect(new PotionEffect(SPEED, 99999, 1, false, false));
        monster.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 99999, 5, false, false));
        monster.addPotionEffect(new PotionEffect(NIGHT_VISION, 99999, 1, false, false));
        monster.addPotionEffect(new PotionEffect(JUMP, 99999, 1, false, false));
        monster.getEquipment().setHelmet(new ItemStack(SKULL_ITEM));
        monster.getEquipment().setChestplate(new ItemStack(LEATHER_CHESTPLATE));
        monster.getEquipment().setLeggings(new ItemStack(LEATHER_LEGGINGS));
        monster.getEquipment().setBoots(new ItemStack(LEATHER_BOOTS));
    }
    
    public static void EndNight()
    {
        monster.getWorld().setTime(6000);
        monster.removePotionEffect(SPEED);
        monster.removePotionEffect(INCREASE_DAMAGE);
        monster.removePotionEffect(NIGHT_VISION);
        monster.removePotionEffect(JUMP);
        monster.getEquipment().setHelmet(new ItemStack(SKULL_ITEM, 0));
        monster.getEquipment().setChestplate(new ItemStack(LEATHER_CHESTPLATE, 0));
        monster.getEquipment().setLeggings(new ItemStack(LEATHER_LEGGINGS, 0));
        monster.getEquipment().setBoots(new ItemStack(LEATHER_BOOTS, 0));
    }
    
    public static boolean isPlayerAlive(String playerName)
    {
        for(Player player:playerList)
        {
            if(playerName.equals(player.getName()))
            {
                return true;
            }
        }
        return false;
    }
    
    // Getters and Setters
    public static Player getMonster ()
    {
        return monster;
    }
}
