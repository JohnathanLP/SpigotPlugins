package eyspSurvival;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

/*
 * This listener will be activated whenever an entity dies. If the entity
 * is an Ender Dragon, it adds an elytra to the list of drops from the mob.
 */

public class ElytraDropListener implements Listener{
	/*
	 * This is the method that is called whenever an entity dies. Note that
	 * when it is called, it is given an event.
	 */
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		//First, we get the entity type from the event
		EntityType entityType = event.getEntityType();
		//Now we check to see if the entity type is Ender Dragon...
		if(entityType == EntityType.ENDER_DRAGON)
		{
			//If it is, we get the list of drops from the entity, and add elytra.
			event.getDrops().add(new ItemStack(Material.ELYTRA));
		}
	}
	
}
