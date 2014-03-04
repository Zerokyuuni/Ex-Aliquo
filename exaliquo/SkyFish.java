package exaliquo;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import static exaliquo.data.ModIDs.getItem;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getBlock;
import exaliquo.skyfish.SkyFishAngel;
import exaliquo.skyfish.SkyFishBass;
import exaliquo.skyfish.SkyFishBlaze;
import exaliquo.skyfish.SkyFishButterfly;
import exaliquo.skyfish.SkyFishCatfish;
import exaliquo.skyfish.SkyFishClown;
import exaliquo.skyfish.SkyFishCod;
import exaliquo.skyfish.SkyFishDamsel;
import exaliquo.skyfish.SkyFishDragon;
import exaliquo.skyfish.SkyFishElectricRay;
import exaliquo.skyfish.SkyFishEnder;
import exaliquo.skyfish.SkyFishGlow;
import exaliquo.skyfish.SkyFishGold;
import exaliquo.skyfish.SkyFishJelly;
import exaliquo.skyfish.SkyFishKoi;
import exaliquo.skyfish.SkyFishManOWar;
import exaliquo.skyfish.SkyFishMantaRay;
import exaliquo.skyfish.SkyFishMinnow;
import exaliquo.skyfish.SkyFishNether;
import exaliquo.skyfish.SkyFishNight;
import exaliquo.skyfish.SkyFishPerch;
import exaliquo.skyfish.SkyFishPiranha;
import exaliquo.skyfish.SkyFishPuffer;
import exaliquo.skyfish.SkyFishSalmon;
import exaliquo.skyfish.SkyFishSiamese;
import exaliquo.skyfish.SkyFishSquid;
import exaliquo.skyfish.SkyFishStingRay;
import exaliquo.skyfish.SkyFishTang;
import exaliquo.skyfish.SkyFishTetra;
import exaliquo.skyfish.SkyFishTuna;
import mariculture.api.fishery.fish.FishSpecies;
import mariculture.api.fishery.EnumRodQuality;
import mariculture.api.fishery.Fishing;
import mariculture.core.Core;
import mariculture.core.helpers.EnchantHelper;
import mariculture.core.lib.FluidContainerMeta;
import mariculture.core.lib.Modules;
import mariculture.fishery.Fishery;
import mariculture.magic.Magic;
import mariculture.world.WorldPlus;

public class SkyFish
{
	public static boolean tastyfish = Loader.isModLoaded("HungerOverhaul");

	public static void overrideFish()
	{
		FishSpecies.speciesList = new ArrayList();
		Fishery.cod = new SkyFishCod(0);
		Fishery.perch = new SkyFishPerch(1);
		Fishery.tuna = new SkyFishTuna(2);
		Fishery.nether = new SkyFishNether(3);
		Fishery.glow = new SkyFishGlow(4);
		Fishery.blaze = new SkyFishBlaze(5);
		Fishery.night = new SkyFishNight(6);
		Fishery.ender = new SkyFishEnder(7);
		Fishery.dragon = new SkyFishDragon(8);
		Fishery.minnow = new SkyFishMinnow(9);
		Fishery.salmon = new SkyFishSalmon(10);
		Fishery.bass = new SkyFishBass(11);
		Fishery.tetra = new SkyFishTetra(12);
		Fishery.catfish = new SkyFishCatfish(13);
		Fishery.piranha = new SkyFishPiranha(14);
		Fishery.stingRay = new SkyFishStingRay(15);
		Fishery.mantaRay = new SkyFishMantaRay(16);
		Fishery.electricRay = new SkyFishElectricRay(17);
		Fishery.damsel = new SkyFishDamsel(18);
		Fishery.angel = new SkyFishAngel(19);
		Fishery.puffer = new SkyFishPuffer(20);
		Fishery.squid = new SkyFishSquid(21);
		Fishery.jelly = new SkyFishJelly(22);
		Fishery.manOWar = new SkyFishManOWar(23);
		Fishery.gold = new SkyFishGold(24);
		Fishery.siamese = new SkyFishSiamese(25);
		Fishery.koi = new SkyFishKoi(26);
		Fishery.butterfly = new SkyFishButterfly(27);
		Fishery.tang = new SkyFishTang(28);
		Fishery.clown = new SkyFishClown(29);

		Fishing.mutation.addMutation(Fishery.nether, Fishery.koi, Fishery.glow, 6D);
		Fishing.mutation.addMutation(Fishery.glow, Fishery.nether, Fishery.blaze, 10D);
		Fishing.mutation.addMutation(Fishery.night, Fishery.electricRay, Fishery.ender, 8D);
		Fishing.mutation.addMutation(Fishery.ender, Fishery.night, Fishery.dragon, 5D);
		Fishing.mutation.addMutation(Fishery.minnow, Fishery.gold, Fishery.salmon, 15D);
		Fishing.mutation.addMutation(Fishery.salmon, Fishery.minnow, Fishery.bass, 20D);
		Fishing.mutation.addMutation(Fishery.tetra, Fishery.siamese, Fishery.catfish, 12D);
		Fishing.mutation.addMutation(Fishery.catfish, Fishery.tetra, Fishery.piranha, 8D);
		Fishing.mutation.addMutation(Fishery.cod, Fishery.gold, Fishery.perch, 15D);
		Fishing.mutation.addMutation(Fishery.perch, Fishery.cod, Fishery.tuna, 20D);
		Fishing.mutation.addMutation(Fishery.stingRay, Fishery.puffer, Fishery.mantaRay, 8D);
		Fishing.mutation.addMutation(Fishery.mantaRay, Fishery.stingRay, Fishery.electricRay, 10D);
		Fishing.mutation.addMutation(Fishery.damsel, Fishery.squid, Fishery.angel, 7.5D);
		Fishing.mutation.addMutation(Fishery.angel, Fishery.damsel, Fishery.puffer, 15D);
		Fishing.mutation.addMutation(Fishery.squid, Fishery.tuna, Fishery.jelly, 20D);
		Fishing.mutation.addMutation(Fishery.jelly, Fishery.squid, Fishery.manOWar, 10D);
		Fishing.mutation.addMutation(Fishery.minnow, Fishery.cod, Fishery.gold, 25D);
		Fishing.mutation.addMutation(Fishery.gold, Fishery.stingRay, Fishery.siamese, 15D);
		Fishing.mutation.addMutation(Fishery.siamese, Fishery.gold, Fishery.koi, 7.5D);
		Fishing.mutation.addMutation(Fishery.angel, Fishery.tetra, Fishery.butterfly, 10D);
		Fishing.mutation.addMutation(Fishery.butterfly, Fishery.piranha, Fishery.tang, 7.5D);
		Fishing.mutation.addMutation(Fishery.tang, Fishery.butterfly, Fishery.clown, 5D);
	}

	public static void addBooty()
	{
		//Fishing.loot.addLoot(stack, args);
		if (Configurations.fishingOysters)
		{
			Fishing.loot.addLoot(new ItemStack(getBlock(Info.marioyster), 1, 0), new Object[] { EnumRodQuality.GOOD, 500 });
		}
		
		Fishing.loot.addLoot(new ItemStack(getBlock(Info.mariores), 1, 7), new Object[] { EnumRodQuality.OLD, 200 });
		
		if (WorldPlus.isActive)
		{
			Item coral = getItem(Info.maricoral);
			for (int i = 2; i < coral.getMaxDamage(); i++)
			{
				Fishing.loot.addLoot(new ItemStack(coral, 1, i), new Object[] { EnumRodQuality.OLD, 1000 });
			}
		}
		
		if (Fishery.isActive)
		{
			if (Configurations.endOverride)
			{
				Fishing.loot.addLoot(new ItemStack(getItem(Info.maribottle), 1, FluidContainerMeta.BOTTLE_VOID), new Object[] { EnumRodQuality.OLD, 75, 1 });
				Fishing.loot.addLoot(new ItemStack(Item.enderPearl), new Object[] { EnumRodQuality.OLD, 300, 1 });
				Fishing.loot.addLoot(new ItemStack(Item.eyeOfEnder), new Object[] { EnumRodQuality.OLD, 250, 1 });
				Fishing.loot.addLoot(new ItemStack(Item.record11), new Object[] { EnumRodQuality.GOOD, 2000, 1 });
				Fishing.loot.addLoot(new ItemStack(Item.recordMellohi), new Object[] { EnumRodQuality.GOOD, 2000, 1 });
				Fishing.loot.addLoot(new ItemStack(Item.recordStal), new Object[] { EnumRodQuality.GOOD, 2000, 1 });
				
				if(Magic.isActive) {
					if(EnchantHelper.exists(Magic.flight)) {
						ItemStack feather = new ItemStack(Item.feather);
						feather.setItemName("Mystical Feather of MagicManMe");
						feather.addEnchantment(Magic.flight, 5);
						Fishing.loot.addLoot(feather, new Object[] { EnumRodQuality.SUPER, 20000, 1 });
					}
				}
			}
		}
	}
}