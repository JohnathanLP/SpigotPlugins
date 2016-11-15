package eyspSurvival;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

/*
 * This class runs in the background, waiting (or listening) until a player
 * tries to use a bed. It then advances to day. Notice that it does this
 * by adding time, rather than setting time. This is so that we don't reset the
 * local difficulty.
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
		//Then we get the current time from the world
		long currTime = world.getTime();
		player.chat("Time is: "+currTime);
		/*
		 * Now we need to figure out how long it is until the next morning.
		 * Days are 24000 ticks long, the game starts at 0 ticks, and 6:00.
		 * This means that currTime%24000 will give us the tick count at 6:00
		 * of the current day. (currTime%24000)+25000 is 7:00 am of the next
		 * day.
		 */
		long tomorrowMorning = (currTime%24000)+25000;
		player.chat("Advancing to : "+tomorrowMorning);
		/*
		 * Now we just set the time to the time we calculated. Note that this
		 * will automatically remove all players from their beds.
		 */
		world.setTime(tomorrowMorning);
		long testTime = world.getTime();
		player.chat("Actual time: "+testTime);
	}
}
