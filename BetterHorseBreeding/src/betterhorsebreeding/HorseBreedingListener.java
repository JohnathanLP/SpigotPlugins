package betterhorsebreeding;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class HorseBreedingListener implements Listener
{
	@EventHandler
	public void onHorseBreed(EntityBreedEvent event)
	{
		EntityType species = event.getEntityType();
		if (species == EntityType.HORSE)
		{
			//LivingEntity entity = event.getEntity();
			Player breeder = (Player)event.getBreeder();
			breeder.sendMessage("Testing");
		}
	}
}
