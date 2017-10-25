package betterhorsebreeding;

import org.bukkit.plugin.java.JavaPlugin;

public class BetterHorseBreeding extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new HorseBreedingListener(), this);
		HorseRuler.createRecipe();
		getServer().getPluginManager().registerEvents(new HorseRulerListener(), this);
	}
	@Override
	public void onDisable()
	{
		
	}
}
