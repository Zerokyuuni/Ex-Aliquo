package exaliquo;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigResearch;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;

public class ExThaumiquo {

	public static void addResearch()
	{
		new ExAResearchItem("SKYCHEMY",
				"SKYCHEMY",
				new AspectList(),
				0,
				0,
				0,
				new ItemStack(Block.cobblestone, 1, 0)).setPages(new ResearchPage("exa.page.SKYCHEMY")).setStub().setRound().setAutoUnlock().registerResearchItem();
		
		if (Configurations.runichax)
		{
			new ExAResearchItem("SKYMATRIX",
					"SKYCHEMY",
					new AspectList().add(Aspect.TOOL, 0).add(Aspect.AIR, 0),
					3,
					4,
					0,
					new ItemStack(getBlock(Info.devices), 1, 2)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.SKYMATRIX.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("SkyMatrix"))
					}).setParentsHidden("INFUSION").setConcealed().setSecondary().registerResearchItem();
			
			new ExAResearchItem("GREATWOOD",
					"SKYCHEMY",
					new AspectList().add(Aspect.TREE, 10).add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10).add(Aspect.SEED, 10),
					0,
					-3,
					3,
					new ItemStack(getBlock(Info.thaumplants), 1, 0)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.GREATWOOD.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("Greatwood1")), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("Greatwood2"))
					}).setParentsHidden("SKYCHEMY", "INFUSION").registerResearchItem();
		}
		else
		{
			new ExAResearchItem("GREATWOOD",
					"SKYCHEMY",
					new AspectList().add(Aspect.TREE, 10).add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10).add(Aspect.SEED, 10),
					0,
					-3,
					3,
					new ItemStack(getBlock(Info.thaumplants), 1, 0)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.GREATWOOD.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("Greatwood1")), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("Greatwood2"))
					}).setParentsHidden("SKYCHEMY", "INFUSION").registerResearchItem();
		}
		
		if (Configurations.silverwoodSwitch == 0)
		{
			new ExAResearchItem("SILVERWOOD1",
					"SKYCHEMY",
					new AspectList().add(Aspect.MAGIC, 20).add(Aspect.TREE, 20).add(Aspect.ORDER, 20).add(Aspect.VOID, 20),
					0,
					3,
					3,
					new ItemStack(getBlock(Info.thaumplants), 1, 1)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.SILVERWOOD.1"), new ResearchPage("exa.page.SILVERWOOD.2"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("Silverwood"))
					}).setConcealed().setSpecial().setParentsHidden(new String[] { "INFUSION", "SHIMMERLEAF", "NODEJAR" }).registerResearchItem();
		}
		else if (Configurations.silverwoodSwitch >= 1)
		{
			new ExAResearchItem("SILVERWOOD2",
					"SKYCHEMY",
					new AspectList().add(Aspect.MAGIC, 20).add(Aspect.TREE, 20).add(Aspect.ORDER, 20).add(Aspect.VOID, 20),
					0,
					3,
					0,
					new ItemStack(getBlock(Info.thaumplants), 1, 1)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.SILVERWOOD.1"), new ResearchPage("exa.page.SILVERWOOD.2"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("Silverwood"))
					}).setConcealed().setSpecial().setParentsHidden(new String[] { "INFUSION", "ETHEREALBLOOM", "NODEJAR" }).registerResearchItem();
		}
		
		new ExAResearchItem("SHIMMERLEAF",
				"SKYCHEMY",
				new AspectList().add(Aspect.PLANT, 6).add(Aspect.EXCHANGE, 6).add(Aspect.MAGIC, 6). add(Aspect.POISON, 6),
				-3,
				0,
				1,
				new ItemStack(getBlock(Info.thaumplants), 1, 2)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.SHIMMERLEAF.1"), new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("Shimmerleaf"))	
				}).setParentsHidden("SKYCHEMY").registerResearchItem();
		
		new ExAResearchItem("CINDERPEARL",
				"SKYCHEMY",
				new AspectList().add(Aspect.FIRE, 6).add(Aspect.MAGIC, 6).add(Aspect.PLANT, 6),
				3,
				0,
				1,
				new ItemStack(getBlock(Info.thaumplants), 1, 3)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.CINDERPEARL.1"), new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("Cinderpearl"))
				}).setParentsHidden("SKYCHEMY").registerResearchItem();
		
		new ExAResearchItem("THAUMHAMMER",
				"SKYCHEMY",
				new AspectList().add(Aspect.TOOL, 0).add(Aspect.AIR, 0),
				-3,
				3,
				0,
				new ItemStack(Registries.hammerThaum)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.THAUMHAMMER.1"), new ResearchPage((IRecipe)ConfigResearch.recipes.get("ThaumiumHammer"))
				}).setParentsHidden("THAUMIUM").setConcealed().setSecondary().registerResearchItem();
		
		new ExAResearchItem("SKYFILTER",
				"SKYCHEMY",
				new AspectList().add(Aspect.TOOL, 0).add(Aspect.AIR, 0),
				3,
				3,
				0,
				new ItemStack(getItem(Info.resources), 1, 8)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.SKYFILTER.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("Skyfilter"))
				}).setParentsHidden("DISTILESSENTIA").setConcealed().setSecondary().registerResearchItem();
	}
	
	public static void addInfusionRecipes()
	{
		if (Configurations.runichax)
		{
			ConfigResearch.recipes.put("Greatwood1", ThaumcraftApi.addInfusionCraftingRecipe("GREATWOOD",
					new ItemStack(getBlock(Info.thaumplants), 1, 0),
					10,
					new AspectList().add(Aspect.TREE, 128).add(Aspect.AIR, 64).add(Aspect.EARTH, 64).add(Aspect.FIRE, 64).add(Aspect.WATER, 64).add(Aspect.ORDER, 64).add(Aspect.ENTROPY, 64),
					new ItemStack(Block.sapling, 1, 3),
					new ItemStack[] {
					new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 2), 
					new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getItem(Info.witchbucket), 1, 0), 
					new ItemStack(getBlock(Info.thaumplants), 1, 3), new ItemStack(getItem(Info.witchbucket), 1, 0)
			}));
			
			ConfigResearch.recipes.put("Greatwood2", ThaumcraftApi.addInfusionCraftingRecipe("GREATWOOD",
					new ItemStack(getBlock(Info.thaumplants), 1, 0),
					10,
					new AspectList().add(Aspect.TREE, 128).add(Aspect.AIR, 64).add(Aspect.EARTH, 64).add(Aspect.FIRE, 64).add(Aspect.WATER, 64).add(Aspect.ORDER, 64).add(Aspect.ENTROPY, 64),
					new ItemStack(Block.sapling, 1, 3),
					new ItemStack[] {
					new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 3), 
					new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getItem(Info.witchbucket), 1, 0), new ItemStack(getItem(Info.witchbucket), 1, 0), 
					new ItemStack(getBlock(Info.thaumplants), 1, 2), new ItemStack(getItem(Info.witchbucket), 1, 0)
			}));
		}
		
		if (Configurations.silverwoodSwitch == 0)
		{
			ConfigResearch.recipes.put("Silverwood",ThaumcraftApi.addInfusionCraftingRecipe("SILVERWOOD1",
					new ItemStack(getBlock(Info.thaumplants), 1, 1),
					15,
					new AspectList().add(Aspect.EXCHANGE, 96).add(Aspect.MAGIC, 96).add(Aspect.CRYSTAL, 96).add(Aspect.TREE, 192),
					new ItemStack(getItem(Info.nodejar), 1, 0),
					new ItemStack[] { 
						new ItemStack(Item.netherStar, 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 2), new ItemStack(Block.blockDiamond, 1, 0),
						new ItemStack(getBlock(Info.thaumplants), 1, 2), new ItemStack(Item.netherStar, 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 2),
						new ItemStack(Block.blockDiamond, 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 2)
			}));
		}
		else if (Configurations.silverwoodSwitch >= 1)
		{
			ConfigResearch.recipes.put("Silverwood",ThaumcraftApi.addInfusionCraftingRecipe("SILVERWOOD2",
					new ItemStack(getBlock(Info.thaumplants), 1, 1),
					12,
					new AspectList().add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64).add(Aspect.CRYSTAL, 64).add(Aspect.TREE, 128),
					new ItemStack(getItem(Info.nodejar), 1, 0),
					new ItemStack[] { 
						new ItemStack(Item.netherStar, 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 4), new ItemStack(Block.blockDiamond, 1, 0),
						new ItemStack(getBlock(Info.thaumplants), 1, 4), new ItemStack(Item.netherStar, 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 4),
						new ItemStack(Block.blockDiamond, 1, 0), new ItemStack(getBlock(Info.thaumplants), 1, 4)
			}));
		}
	}

	public static void addCrucibleRecipes()
	{
		ConfigResearch.recipes.put("Shimmerleaf", ThaumcraftApi.addCrucibleRecipe("SHIMMERLEAF", new ItemStack(getBlock(Info.thaumplants), 1, 2), new ItemStack(Block.plantRed, 1, 0), new AspectList().add(Aspect.MAGIC, 12).add(Aspect.EXCHANGE, 12).add(Aspect.PLANT, 12).add(Aspect.POISON, 12)));
		ConfigResearch.recipes.put("Cinderpearl", ThaumcraftApi.addCrucibleRecipe("CINDERPEARL", new ItemStack(getBlock(Info.thaumplants), 1, 3), new ItemStack(Block.plantYellow, 1, 0), new AspectList().add(Aspect.MAGIC, 12).add(Aspect.EXCHANGE, 12). add(Aspect.PLANT, 12).add(Aspect.FIRE, 12)));
	}
	
	public static void addArcaneRecipes()
	{
	    ConfigResearch.recipes.put("Skyfilter", ThaumcraftApi.addArcaneCraftingRecipe("SKYFILTER", new ItemStack(getItem(Info.resources), 1, 8), new AspectList().add(Aspect.ORDER, 5).add(Aspect.WATER, 5), new Object[] { "mmm", "imi", "mmm", 'i', Item.ingotGold, 'm', new ItemStack(getItem(Info.mesh), 1, 0) }));
	    if (Configurations.runichax)
	    {
	    	ConfigResearch.recipes.put("SkyMatrix", ThaumcraftApi.addArcaneCraftingRecipe("SKYMATRIX", new ItemStack(getBlock(Info.devices), 1, 2), new AspectList().add(Aspect.AIR, 10).add(Aspect.EARTH, 10).add(Aspect.FIRE, 10).add(Aspect.WATER, 10).add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10), new Object[] { "bcb", "cec", "bcb", 'b', new ItemStack(getBlock(Info.cosmetics), 1, 6), 'c', new ItemStack(getBlock(Info.cluster), 1, 6), 'e', Item.enderPearl }));
	    }
	    else
	    {
	    	ConfigResearch.recipes.put("Greatwood1", ThaumcraftApi.addArcaneCraftingRecipe("GREATWOOD", new ItemStack(getBlock(Info.thaumplants), 1, 0), new AspectList().add(Aspect.AIR, 25).add(Aspect.EARTH, 25).add(Aspect.FIRE, 25).add(Aspect.WATER, 25).add(Aspect.ORDER, 25).add(Aspect.ENTROPY, 25), new Object[] { "www", "csl", "www", 'w', getItem(Info.witchbucket), 'c', new ItemStack(getBlock(Info.thaumplants), 1, 3), 'l', new ItemStack(getBlock(Info.thaumplants),1, 2), 's', new ItemStack(Block.sapling, 1, 3) }));
	    	ConfigResearch.recipes.put("Greatwood2", ThaumcraftApi.addArcaneCraftingRecipe("GREATWOOD", new ItemStack(getBlock(Info.thaumplants), 1, 0), new AspectList().add(Aspect.AIR, 25).add(Aspect.EARTH, 25).add(Aspect.FIRE, 25).add(Aspect.WATER, 25).add(Aspect.ORDER, 25).add(Aspect.ENTROPY, 25), new Object[] { "www", "lsc", "www", 'w', getItem(Info.witchbucket), 'c', new ItemStack(getBlock(Info.thaumplants), 1, 3), 'l', new ItemStack(getBlock(Info.thaumplants),1, 2), 's', new ItemStack(Block.sapling, 1, 3) }));
	    }
	}

	public static void addWorkbenchRecipes()
	{
		addOreDictRecipes("ThaumiumHammer", new ItemStack(Registries.hammerThaum, 1, 0), new Object[] { " t ", " st", "s  ", 's', "stickWood", 't', new ItemStack(getItem(Info.resources), 1, 2)});
	}
	
	static void addOreDictRecipes(String name, ItemStack stack, Object[] recipe)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(stack, recipe));
		List<IRecipe> irecipe = CraftingManager.getInstance().getRecipeList();
		ConfigResearch.recipes.put(name, irecipe.get(irecipe.size() -1));
	}

	public static void addAspectstoNihilo() 
	{
		ThaumcraftApi.registerObjectTag(getIDs(Info.ironore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.STONE, 1).add(Aspect.EARTH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.ironore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.ironore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.goldore), 0, new AspectList().add(Aspect.METAL, 2).add(Aspect.STONE, 1).add(Aspect.EARTH, 1).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.goldore), 1, new AspectList().add(Aspect.METAL, 2).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.goldore), 2, new AspectList().add(Aspect.METAL, 2).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.copperore), 0, new AspectList().add(Aspect.METAL, 2).add(Aspect.STONE, 1).add(Aspect.EARTH, 1).add(Aspect.EXCHANGE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.copperore), 1, new AspectList().add(Aspect.METAL, 2).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1).add(Aspect.EXCHANGE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.copperore), 2, new AspectList().add(Aspect.METAL, 2).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1).add(Aspect.EXCHANGE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.tinore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 1).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.tinore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 2).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.tinore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 2).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silverore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 1).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silverore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 2).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silverore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 2).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.leadore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.ORDER, 1).add(Aspect.ENTROPY, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.leadore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 2).add(Aspect.ORDER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.leadore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 2).add(Aspect.ORDER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nickelore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.STONE, 1).add(Aspect.VOID, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nickelore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 1).add(Aspect.VOID, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nickelore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1).add(Aspect.VOID, 1));
		
		ThaumcraftApi.registerObjectTag("orePlatinum", new AspectList().merge(Aspect.METAL, 2).merge(Aspect.GREED, 1).merge(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.platinumore), 0, new AspectList().add(Aspect.METAL, 2).add(Aspect.GREED, 1).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.platinumore), 1, new AspectList().add(Aspect.METAL, 2).add(Aspect.GREED, 1).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.platinumore), 2, new AspectList().add(Aspect.METAL, 2).add(Aspect.AIR, 1).add(Aspect.GREED, 1).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.osmiumore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.STONE, 1).add(Aspect.EARTH, 1).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.osmiumore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1).add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.osmiumore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1).add(Aspect.GREED, 1));
		
		ThaumcraftApi.registerObjectTag("oreAluminum", new AspectList().merge(Aspect.METAL, 2).merge(Aspect.MECHANISM, 1).merge(Aspect.AIR, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.aluminumore), 0, new AspectList().add(Aspect.METAL, 3).add(Aspect.STONE, 1).add(Aspect.EARTH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.aluminumore), 1, new AspectList().add(Aspect.METAL, 3).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.aluminumore), 2, new AspectList().add(Aspect.METAL, 3).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1));
	
		
		ThaumcraftApi.registerObjectTag(getIDs(Info.irongrav), 0, new AspectList().add(Aspect.METAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.ironsand), 0, new AspectList().add(Aspect.METAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.irondust), 0, new AspectList().add(Aspect.METAL, 1).add(Aspect.AIR,1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.goldgrav), 0, new AspectList().add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.goldsand), 0, new AspectList().add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.golddust), 0, new AspectList().add(Aspect.GREED, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotCopper", new AspectList().merge(Aspect.METAL, 3).add(Aspect.EXCHANGE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.coppergrav), 0, new AspectList().add(Aspect.EXCHANGE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.coppersand), 0, new AspectList().add(Aspect.EXCHANGE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.copperdust), 0, new AspectList().add(Aspect.EXCHANGE, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotTin", new AspectList().merge(Aspect.METAL, 3).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.tingrav), 0, new AspectList().add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.tinsand), 0, new AspectList().add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.tindust), 0, new AspectList().add(Aspect.CRYSTAL, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotSilver", new AspectList().merge(Aspect.METAL, 3).merge(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silvergrav), 0, new AspectList().add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silversand), 0, new AspectList().add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silverdust), 0, new AspectList().add(Aspect.GREED, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotLead", new AspectList().merge(Aspect.METAL, 3).merge(Aspect.ORDER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.leadgrav), 0, new AspectList().add(Aspect.ORDER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.leadsand), 0, new AspectList().add(Aspect.ORDER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.leaddust), 0, new AspectList().add(Aspect.ORDER, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotNickel", new AspectList().merge(Aspect.METAL, 3).merge(Aspect.VOID, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nickelgrav), 0, new AspectList().add(Aspect.VOID, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nickelsand), 0, new AspectList().add(Aspect.VOID, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nickeldust), 0, new AspectList().add(Aspect.VOID, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotPlatinum", new AspectList().merge(Aspect.METAL, 3).merge(Aspect.GREED, 2).merge(Aspect.CRYSTAL, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.platinumgrav), 0, new AspectList().add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.platinumsand), 0, new AspectList().add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.platinumdust), 0, new AspectList().add(Aspect.CRYSTAL, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag(getIDs(Info.osmiumgrav), 0, new AspectList().add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.osmiumsand), 0, new AspectList().add(Aspect.GREED, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.osmiumdust), 0, new AspectList().add(Aspect.GREED, 1).add(Aspect.AIR, 1));
		
		ThaumcraftApi.registerObjectTag("ingotAluminum", new AspectList().add(Aspect.METAL, 4).add(Aspect.AIR, 2).add(Aspect.MECHANISM, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.aluminumgrav), 0, new AspectList().add(Aspect.AIR, 1).add(Aspect.MECHANISM, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.aluminumsand), 0, new AspectList().add(Aspect.AIR, 1).add(Aspect.MECHANISM, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.aluminumdust), 0, new AspectList().add(Aspect.AIR, 2).add(Aspect.MECHANISM, 1));
		
		ThaumcraftApi.registerObjectTag(getIDs(Info.beetrap), 0, new AspectList().add(Aspect.BEAST, 1).add(Aspect.MECHANISM, 3).add(Aspect.PLANT, 8));
		ThaumcraftApi.registerObjectTag(getIDs(Info.scentedtrap), 0, new AspectList().add(Aspect.BEAST, 1).add(Aspect.TRAP, 3).add(Aspect.SEED, 8));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silkleaves), 0, new AspectList().add(Aspect.PLANT, 1).add(Aspect.CLOTH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.witchwater), 0, new AspectList().add(Aspect.WATER, 1).add(Aspect.POISON, 3).add(Aspect.DEATH, 3).add(Aspect.TAINT, 3).add(Aspect.DARKNESS, 3));
		ThaumcraftApi.registerObjectTag(getIDs(Info.woodbarrel), 0, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.woodbarrel), 1, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.woodbarrel), 2, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.woodbarrel), 3, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.stonebarrel), 0, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 2));
		ThaumcraftApi.registerObjectTag(getIDs(Info.grass), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1).add(Aspect.LIFE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.spores), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1).add(Aspect.LIFE, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.cactusseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 3).add(Aspect.WATER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.caneseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1).add(Aspect.WATER, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.taterseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.ENTROPY, 1).add(Aspect.CROP, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.carrotseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.AIR, 1).add(Aspect.CROP, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.oakseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.zebraseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.spruceseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.jungleseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.rubberseed), 0, new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1).add(Aspect.SLIME, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.silkworm), 0, new AspectList().add(Aspect.BEAST, 1).add(Aspect.CLOTH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.nomworm), 0, new AspectList().add(Aspect.BEAST, 1).add(Aspect.HUNGER, 1).add(Aspect.FLESH, 1));
		ThaumcraftApi.registerObjectTag(getIDs(Info.witchbucket), 0, new AspectList().add(Aspect.METAL, 8).add(Aspect.VOID, 1).add(Aspect.WATER, 1).add(Aspect.POISON, 3).add(Aspect.DEATH, 3).add(Aspect.TAINT, 3).add(Aspect.DARKNESS, 3));
		ThaumcraftApi.registerObjectTag(getIDs(Info.stones), 0, new AspectList().add(Aspect.STONE, 1));
	}

	public static void addPages()
	{
		ResearchCategories.registerCategory("SKYCHEMY", new ResourceLocation("exaliquo:textures/misc/thaumicpage.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
	}
}
