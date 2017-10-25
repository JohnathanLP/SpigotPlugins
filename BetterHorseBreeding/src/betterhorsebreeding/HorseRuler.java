package betterhorsebreeding;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class HorseRuler 
{
	public static void createRecipe()
	{
		ItemStack ruler = new ItemStack(Material.STICK);
		ItemMeta meta = ruler.getItemMeta();
		meta.setDisplayName("Horse Ruler");
		
		ruler.setItemMeta(meta);
		
		ShapedRecipe rulerRecipe = new ShapedRecipe(ruler);
		rulerRecipe.shape(" a ", " s ", " a ");
		rulerRecipe.setIngredient('a', Material.GOLDEN_APPLE);
		rulerRecipe.setIngredient('s', Material.STICK);
		Bukkit.addRecipe(rulerRecipe);
	}
}
