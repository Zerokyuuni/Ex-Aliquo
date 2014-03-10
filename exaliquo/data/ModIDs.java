package exaliquo.data;

import java.util.logging.Level;
import java.util.logging.Logger;

import static cpw.mods.fml.common.registry.GameRegistry.findBlock;
import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import exaliquo.exaliquo;
import exaliquo.data.ModIDs.Info;

public class ModIDs
{
	public enum Info
	{
		woodbarrel("crowley.skyblock","block","barrel"),
		stonebarrel("crowley.skyblock","block","barrel_stone"),
		crucible("crowley.skyblock","block","crucible"),
		dust("crowley.skyblock","block","dust"),
		silkleaves("crowley.skyblock","block","infested_leaves"),
		beetrap("crowley.skyblock","block","bee_trap"),
		scentedtrap("crowley.skyblock","block","bee_trap_treated"),
		witchwater("crowley.skyblock","block","witchwater"),
		ironore("crowley.skyblock","block","iron_ore"),
		goldore("crowley.skyblock","block","gold_ore"),
		copperore("crowley.skyblock","block","copper_ore"),
		tinore("crowley.skyblock","block","tin_ore"),
		silverore("crowley.skyblock","block","silver_ore"),
		leadore("crowley.skyblock","block","lead_ore"),
		nickelore("crowley.skyblock","block","nickel_ore"),
		platinumore("crowley.skyblock","block","platinum_ore"),
		osmiumore("crowley.skyblock","block","osmium_ore"),
		aluminumore("crowley.skyblock","block","aluminum_ore"),
		silkworm("crowley.skyblock","item","silkworm"),
		nomworm("crowley.skyblock","item","silkworm_cooked"),
		spores("crowley.skyblock","item","spores"),
		grass("crowley.skyblock","item","seed_grass"),
		oakseed("crowley.skyblock","item","seed_oak"),
		zebraseed("crowley.skyblock","item","seed_birch"),
		spruceseed("crowley.skyblock","item","seed_spruce"),
		jungleseed("crowley.skyblock","item","seed_jungle"),
		cactusseed("crowley.skyblock","item","seed_cactus"),
		caneseed("crowley.skyblock","item","seed_sugar_cane"),
		carrotseed("crowley.skyblock","item","seed_carrot"),
		taterseed("crowley.skyblock","item","seed_potato"),
		rubberseed("crowley.skyblock","item","seed_rubber"),
		witchbucket("crowley.skyblock","item","bucket_witchwater"),
		mesh("crowley.skyblock","item","mesh"),
		irongrav("crowley.skyblock","item","iron_broken"),
		ironsand("crowley.skyblock","item","iron_crushed"),
		irondust("crowley.skyblock","item","iron_pulverized"),
		goldgrav("crowley.skyblock","item","gold_broken"),
		goldsand("crowley.skyblock","item","gold_crushed"),
		golddust("crowley.skyblock","item","gold_pulverized"),
		coppergrav("crowley.skyblock","item","copper_broken"),
		coppersand("crowley.skyblock","item","copper_crushed"),
		copperdust("crowley.skyblock","item","copper_pulverized"),
		tingrav("crowley.skyblock","item","tin_broken"),
		tinsand("crowley.skyblock","item","tin_crushed"),
		tindust("crowley.skyblock","item","tin_pulverized"),
		silvergrav("crowley.skyblock","item","silver_broken"),
		silversand("crowley.skyblock","item","silver_crushed"),
		silverdust("crowley.skyblock","item","silver_pulverized"),
		leadgrav("crowley.skyblock","item","lead_broken"),
		leadsand("crowley.skyblock","item","lead_crushed"),
		leaddust("crowley.skyblock","item","lead_pulverized"),
		nickelgrav("crowley.skyblock","item","nickel_broken"),
		nickelsand("crowley.skyblock","item","nickel_crushed"),
		nickeldust("crowley.skyblock","item","nickel_pulverized"),
		platinumgrav("crowley.skyblock","item","platinum_broken"),
		platinumsand("crowley.skyblock","item","platinum_crushed"),
		platinumdust("crowley.skyblock","item","platinum_pulverized"),
		osmiumgrav("crowley.skyblock","item","osmium_broken"),
		osmiumsand("crowley.skyblock","item","osmium_crushed"),
		osmiumdust("crowley.skyblock","item","osmium_pulverized"),
		aluminumgrav("crowley.skyblock","item","aluminum_broken"),
		aluminumsand("crowley.skyblock","item","aluminum_crushed"),
		aluminumdust("crowley.skyblock","item","aluminum_pulverized"),
		stones("crowley.skyblock","item","stone"),
		
		oreberrybush("TConstruct","block","ore.berries.one"),
		oreberrybush2("TConstruct","block","ore.berries.two"),
		hambone("TConstruct","block","MeatBlock"),
		storch("TConstruct","block","decoration.stonetorch"),
		craftedsoil("TConstruct","block","CraftedSoil"),
		materials("TConstruct","item","materials"),
		oreberry("TConstruct","item","oreBerries"),
		tinkerfood("TConstruct","item","strangeFood"),
		
		flora("Natura","block","florasapling"),
		leaves("Natura","block","floraleaves"),
		raresap("Natura","block","Rare Sapling"),
		rareleaves("Natura","block","Rare Leaves"),
		darkleaves("Natura","block","Dark Leaves"),
		monochrome("Natura","block","floraleavesnocolor"),
		good("Natura","block","BerryBush"),
		evil("Natura","block","NetherBerryBush"),
		glowshroom("Natura","block","Glowshroom"),
		thornvines("Natura","block","Thornvines"),
		cactus("Natura","block","Saguaro"),
		bluebell("Natura","block","Bluebells"),
		topiary("Natura","block","GrassBlock"),
		nethersoil("Natura","block","soil.tainted"),
		nethersand("Natura","block","heatsand"),
		fruit("Natura","item","saguaro.fruit"),
		goodberry("Natura","item","berry"),
		badberry("Natura","item","berry.nether"),
		potash("Natura","item","Natura.netherfood"),
		plants("Natura","item","barleyFood"),
		impmeat("Natura","item","impmeat"),
		
		orchid("arsmagica2","block","blueOrchid"),
		nova("arsmagica2","block","desertNova"),
		aum("arsmagica2","block","Aum"),
		witchwood("arsmagica2","block","saplingWitchwood"),
		witchleaves("arsmagica2","block","WitchwoodLeaves"),
		wakebloom("arsmagica2","block","WakeBloom"),
		tarma("arsmagica2","block","TarmaRoot"),
		essenceBlock("arsmagica2","block","liquidEssence"),
		vtorch("arsmagica2","block","VinteumTorch"),
		essenceBucket("arsmagica2","item","liquidEssenceBucket"),
		magicore("arsmagica2","item","itemOre"),
		essences("arsmagica2","item","essence"),
		
		thaumplants("Thaumcraft","block","blockCustomPlant"),
		thaumleaves("Thaumcraft","block","blockMagicalLeaves"),
		ttorch("Thaumcraft","block","blockAiry"),
		candle("Thaumcraft","block","blockCandle"),
		devices("Thaumcraft","block","blockStoneDevice"),
		cosmetics("Thaumcraft","block","blockCosmeticSolid"),
		cluster("Thaumcraft","block","blockCrystal"),
		shard("Thaumcraft","item","ItemShard"),
		resources("Thaumcraft","item","ItemResource"),
		nuggets("Thaumcraft","item","ItemNugget"),
		manabean("Thaumcraft","item","ItemManaBean"),
		nodejar("Thaumcraft","item","BlockJarNodeItem"),
		
		gcsappling("Growthcraft|Apples","block","grc.appleSapling"),
		gcbamboo("Growthcraft|Bamboo","block","grc.bambooShoot"),
		gcleaves("Growthcraft|Bamboo","block","grc.bambooLeaves"),
		gcapple("Growthcraft|Apples","item","grc.appleSeeds"),
		gcbee("Growthcraft|Bees","item","grc.bee"),
		
		mariores("Mariculture","block","oreBlocks"),
		marioyster("Mariculture","block","oysterBlock"),
		maricoral("Mariculture","item","coral"),
		maribottle("Mariculture","item","liquidContainers"),
		
		hellfeesh("NetherOres","block","netherOresBlockHellfish"),
		
		rubbersapling("MineFactoryReloaded","block","mfr.rubberwood.sapling"),
		rubberleaves("MineFactoryReloaded","block","mfr.rubberwood.leaves");
		
		private final String mod;
		private final String type;
		private final String sname;
		
		private Info(String mod, String type, String sname)
		{
			this.mod = mod;
			this.type = type;
			this.sname = sname;
		}
		
		private String mod() { return mod; }
		private String type() { return type; }
		private String sname() {return sname; }
	}
	public static int getIDs(Info info)
	{
		if (info.type == "block")
		{
			Block id = findBlock(info.mod, info.sname);
			return (id != null) ? id.blockID : debugIDInfo(info);
		}
		else
		{
			Item id = findItem(info.mod, info.sname);
			return (id != null) ? id.itemID : debugIDInfo(info);
		}
	}
	
	public static Block getBlock(Info info)
	{
		Block block = findBlock(info.mod, info.sname);
		return (block != null) ? block : debugBlockInfo(info);
	}
	
	public static Item getItem(Info info)
	{
		Item item = findItem(info.mod, info.sname);
		return (item != null) ? item : debugItemInfo(info);
	}
	
	private static int debugIDInfo(Info info)
	{
		exaliquo.logger.log(Level.WARNING,"The " + info.type + "ID from " + info.mod + " called as " + info.sname + " could not be found.");
		return Block.sponge.blockID;
	}
	private static Block debugBlockInfo(Info info)
	{
		exaliquo.logger.log(Level.WARNING,"The block from " + info.mod + "called as " + info.sname + " could not be found");
		return Block.cake;
	}
	private static Item debugItemInfo(Info info)
	{
		exaliquo.logger.log(Level.WARNING,"The item from " + info.mod + " called as " + info.sname + " could not be found.");
		return Item.cake;
	}
}