package eyspSurvival;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
 * This class contains a method to handle the /noob command.
 */

public class NoobCommand implements CommandExecutor{
	/*
	 * This method is called whenever the /noob command is used. Note that when it is called,
	 * it receives a huge list of arguments
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		//First, we get the player who used the command from the CommandSender argument
		Player player = (Player)sender;
		//Then, we get the player's inventory, and add a crafting table.
		player.getInventory().addItem(new ItemStack(Material.WORKBENCH));
		//Shame the player a bit for using noob help.
		player.chat("Thanks for the crafting table, noob help!");
		return true;
	}
}
