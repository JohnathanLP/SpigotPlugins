package eyspSurvival;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

/*
 * This class runs in the background, waiting (or listening) until a player
 * tries to use a bed. It then advances to day.
 */

public class BedListener implements Listener{
	/*
	 * This is the method that is called whenever someone gets in bed. Notice
	 * that when it is called, it receives an event.
	 */
	@EventHandler
	public void onPlayerSleep(PlayerBedEnterEvent event){
		//First we get the player from the event
		Player player = event.getPlayer();
		//Then we get the world from the player
		World world = player.getWorld();
		//Now we set the time
		world.setTime(1000);
	}
}
