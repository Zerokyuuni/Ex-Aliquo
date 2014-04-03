package exaliquo.bridges.crossmod;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class CropXYZ
{
	private static final String[] Number = { "Apple", "Advocado", "Banana", "Barley", "Blackberry", "Cactusfruit", "Cherry", "Cinnamon", "Coconut", "Corn", "Cotton", "Cranberry", "DragonFruit", "Grape", "Kiwi", "Lemon", "Lime", "Mango", "Nutmeg", "Olive", "Orange", "Papaya", "Peach", "Pear", "Plum", "Peppercorn", "Pomegranate", "Raspberry", "Rutabaga", "Rhubarb", "Lettuce", "Brusselsprout", "Maloberry", "Rye", "Rice", "Vanillabean", "Mushroom", "Citron", "BuddhaHand", "Blueberry", "Chestnut", "Date", "Kumquat", "Blackthorn", "Almond", "Apricot", "Grapefruit", "Pomelo", "SandPear", "Hazelnut", "Beechnut", "Pecan", "Plantain", "BrazilNut", "Fig", "Acorn", "Elderberry", "GinkoNut", "Coffee", "OsangeOrange", "Clove", "Artichoke", "Bambooshoot", "Bean", "Beet", "Bellpepper", "Broccoli", "Cabbage", "Candle", "Canteloupe", "Celery", "Chilipepper", "Cucumber", "Edibleroot", "Eggplant", "Garlic", "Ginger", "Leek", "Mustard", "Oats", "Okra", "Onion", "Parsnip", "Peanut", "Peas", "Pineapple", "Radish", "Scallion", "Seaweed", "Soybean", "Spiceleaf", "Starfruit", "Strawberry", "Sunflower", "Sweetpotato", "Tea", "Tomato", "Turnip", "Whitemushroom", "Wintersquash", "Zucchini" };
	
	public static void Shoukan()
	{
		for (int i = 0; i < Number.length; i++)
		{
			ArrayList<ItemStack> Kibou = OreDictionary.getOres("crop"+Number[i]);
			if (!Kibou.isEmpty())
			{
				for (ItemStack Hope : Kibou)
				{
					register(Hope.itemID, 0, 0.125F, color("tall_grass"));
				}
			}
			
			ArrayList<ItemStack> TheSeventhOne = OreDictionary.getOres("seed"+Number[i]);
			if (!TheSeventhOne.isEmpty())
			{
				for (ItemStack Chaos : TheSeventhOne)
				{
					register(Chaos.itemID, 0, 0.125F, color("tall_grass"));
				}
			}
		}
	}
}
