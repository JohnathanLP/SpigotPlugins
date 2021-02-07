package template_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.NamespacedKey;

public class TemplatePlugin extends JavaPlugin
{
	@Override
	public void onEnable()
    {
		this.getCommand("greeting").setExecutor(new GreetingCommand());
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        ItemStack item = new ItemStack(Material.TRIDENT);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "Trident"), item);
        recipe.shape("DID", " S ", " S ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(recipe);
	}
	@Override
	public void onDisable(){

	}
}
