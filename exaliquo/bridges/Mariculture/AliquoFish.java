package exaliquo.bridges.Mariculture;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import exaliquo.data.Configurations;
import static exaliquo.data.ModIDs.*;
import mariculture.api.fishery.Fishing;
import mariculture.api.fishery.Loot;
import mariculture.api.fishery.Loot.Rarity;
import mariculture.api.fishery.RodQuality;
import mariculture.core.lib.Modules;

public class AliquoFish
{
	protected static void InitFishery()
	{
		addBooty();
	}

	static void addBooty()
	{
		if (Configurations.fishingOysters)
		{
			Fishing.loot.addLoot(new Loot(new ItemStack(getBlock(Info.marioyster)), RodQuality.GOOD, Rarity.GOOD, 100, 0, false));
		}
		
		Fishing.loot.addLoot(new Loot(new ItemStack(getBlock(Info.mariores), 1, 7), RodQuality.OLD, Rarity.JUNK, 50, 0, false));
		
		if (Modules.isActive(Modules.worldplus))
		{
			Item coral = getItem(Info.maricoral);
			for (int i = 2; i < coral.getMaxDamage(); i++)
			{
				Fishing.loot.addLoot(new Loot(new ItemStack(coral, 1, i), RodQuality.OLD, Rarity.JUNK, 200, 0, false));
			}
		}
	}
}