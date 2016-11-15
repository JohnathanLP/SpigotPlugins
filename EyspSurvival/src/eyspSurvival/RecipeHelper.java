package eyspSurvival;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/*
 * This class contains a method called CreateRecipes which adds all of our custom
 * crafting recipes. We could technically have done all of this in the main class,
 * but doing it here makes it so much neater.
 */

public class RecipeHelper {
	public static void CreateRecipes(){
		/*
		 * First, we will create a recipe to make an Emerald Sword. We start by
		 * creating a stack of a single Diamond Sword called emeraldSword
		 */
		ItemStack emeraldSword = new ItemStack(Material.DIAMOND_SWORD);
		/*
		 * We want to change some things about our emerald sword. To do this, we
		 * need to pull out the ItemMeta.
		 */
		ItemMeta swordMeta = emeraldSword.getItemMeta();
		//Now we set the name of the sword
		swordMeta.setDisplayName("Emerald Sword");
		//We also want to set the lore, which has be be done in a weird way.
		List<String> swordLore = Arrays.asList("Made from Emeralds, this sword", "increases your loot");
		swordMeta.setLore(swordLore);
		//Then we update the item with our new metadata.
		emeraldSword.setItemMeta(swordMeta);
		//Now we add a looting enchantment
		emeraldSword.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 1);
		/*
		 * Now we have to create the recipe. We first create a ShapedRecipe called
		 * swordRecipe, and set it up to give us one of our emeraldSword stacks we
		 * created earlier.
		 */
		ShapedRecipe swordRecipe = new ShapedRecipe(emeraldSword);
		/*
		 * Now we create the recipe for our sword. Notice that it has spaces to 
		 * indicate empty space.
		 */
		swordRecipe.shape(" E "," E "," S ");
		/*
		 * Then we have to tell it what the E and S represented in the recipe we
		 * defined above.
		 */
		swordRecipe.setIngredient('E', Material.EMERALD);
		swordRecipe.setIngredient('S', Material.STICK);
		//Finally, we add the recipe to the game. This line is important!
		Bukkit.addRecipe(swordRecipe);
	}
}
