package eyspSurvival;

import org.bukkit.plugin.java.JavaPlugin;

/*
 *This is the main class. It contains two methods, onEnable and onDisable. 
 *These are called, as you might imagine, when the plugin is enabled or 
 *disabled.
 */

public class EyspSurvival extends JavaPlugin{
	@Override
	public void onEnable(){
		//This line starts our BedListener. Go go BedListener class to learn more.
		getServer().getPluginManager().registerEvents(new BedListener(), this);
		//This line starts our ElytraDropListener. Go to ElytraDropListener class to learn more.
		getServer().getPluginManager().registerEvents(new ElytraDropListener(), this);
		//This line calls our CreateRecipes method. Go to RecipeHelper class to learn more.
		RecipeHelper.CreateRecipes();
	}
	@Override
	public void onDisable(){
		
	}
}
