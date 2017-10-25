package betterhorsebreeding;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Horse;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class HorseRulerListener implements Listener
{
	@EventHandler
	public void onRulerUse(PlayerInteractEntityEvent event)
	{
		if(event.getRightClicked().getType() == EntityType.HORSE)
		{
			if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK)
			//if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName() == "Horse Ruler")
			{
				Horse horse = (Horse)event.getRightClicked();
				//event.getPlayer().sendMessage("Raw Speed: " + Double.toString(horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue()));
				double jumpValue = Math.floor(horse.getJumpStrength()*10000)/10000;
				double jumpPercent = Math.floor((jumpValue-.4)/.006*100)/100;
				double speedValue =Math.floor(horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue()*10000)/10000;
				double speedPercent = Math.floor((speedValue - .1125)/.002250*100)/100;
				event.getPlayer().sendMessage("Jump Strength: " + jumpPercent + "% (" + jumpValue + ")");
				event.getPlayer().sendMessage("Speed: " + speedPercent + "% (" + speedValue + ")");
				event.setCancelled(true);
			}
		}
//		Player p = event.getPlayer();
//		Entity e = event.getRightClicked();
//		ItemStack i = p.getInventory().getItemInMainHand();
//		if(e.getType() == EntityType.HORSE && i.getItemMeta().getDisplayName() == "Horse Ruler")		
//		{
//			p.sendMessage("This is a Horse");
//		}
//		else
//		{
//			p.sendMessage("This is not a Horse");
//		}
//		event.setCancelled(true);
	}
}
