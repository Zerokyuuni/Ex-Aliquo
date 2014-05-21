package exaliquo.bridges.Thaumcraft;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import cpw.mods.fml.common.Loader;
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
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategoryList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.wands.WandRod;
import thaumcraft.common.config.ConfigResearch;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.Registries;
import exaliquo.exaliquo;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;

public class ExThaumiquo
{
	
	protected static void initThaumiquo()
	{
		addWorkbenchRecipes();
		addCrucibleRecipes();
		addArcaneRecipes();
		addInfusionRecipes();
		addAspectstoNihilo();
		addPages();
		addResearch();
		if (Configurations.harderWands)
		{
			changePrimalWands();
		}
	}
	
	static void addResearch()
	{
		new ExAResearchItem("SKYCHEMY",
				"SKYCHEMY",
				new AspectList(),
				0,
				0,
				0,
				new ItemStack(Block.cobblestone, 1, 0)).setPages(new ResearchPage[] {		
				new ResearchPage("exa.page.SKYCHEMY.1"), new ResearchPage("exa.page.SKYCHEMY.2"), new ResearchPage("exa.page.SKYCHEMY." + (Configurations.alternatewater ? 3 : 4))
				}).setStub().setRound().setAutoUnlock().registerResearchItem();
		
		if (Configurations.runichax)
		{
			new ExAResearchItem("SKYMATRIX",
					"SKYCHEMY",
					new AspectList().add(Aspect.EARTH,1),
					3,
					4,
					0,
					new ItemStack(getBlock(Info.devices), 1, 2)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.SKYMATRIX.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("SkyMatrix"))
					}).setConcealed().setParentsHidden("INFUSION").setStub().registerResearchItem();
			
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
				new AspectList().add(Aspect.EARTH,1),
				-3,
				3,
				0,
				new ItemStack(Registries.hammerThaum)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.THAUMHAMMER.1"), new ResearchPage((IRecipe)ConfigResearch.recipes.get("ThaumiumHammer"))
				}).setConcealed().setParentsHidden("THAUMIUM").setStub().registerResearchItem();
		
		new ExAResearchItem("SKYFILTER",
				"SKYCHEMY",
				new AspectList().add(Aspect.EARTH,1),
				3,
				3,
				0,
				new ItemStack(getItem(Info.resources), 1, 8)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.SKYFILTER.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("Skyfilter"))
				}).setConcealed().setParentsHidden("DISTILESSENTIA").setStub().registerResearchItem();
		
		new ExAResearchItem("OBSIDIANTOTEM",
				"SKYCHEMY",
				new AspectList().add(Aspect.ELDRITCH, 3).add(Aspect.EARTH, 8).add(Aspect.DARKNESS, 3),
				2,
				4,
				1,
				new ItemStack(getBlock(Info.cosmetics), 1, 0)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.OBSIDIANTOTEM.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("ObsidianTotem"))
				}).setSecondary().registerResearchItem();
	}
	
	static void addInfusionRecipes()
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

	static void addCrucibleRecipes()
	{
		ConfigResearch.recipes.put("Shimmerleaf", ThaumcraftApi.addCrucibleRecipe("SHIMMERLEAF", new ItemStack(getBlock(Info.thaumplants), 1, 2), new ItemStack(Block.plantRed, 1, 0), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.EXCHANGE, 4).add(Aspect.PLANT, 4).add(Aspect.POISON, 4)));
		ConfigResearch.recipes.put("Cinderpearl", ThaumcraftApi.addCrucibleRecipe("CINDERPEARL", new ItemStack(getBlock(Info.thaumplants), 1, 3), new ItemStack(Block.plantYellow, 1, 0), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.EXCHANGE, 4). add(Aspect.PLANT, 4).add(Aspect.FIRE, 4)));
	}
	
	static void addArcaneRecipes()
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
	    ConfigResearch.recipes.put("ObsidianTotem", ThaumcraftApi.addArcaneCraftingRecipe("OBSIDIANTOTEM", new ItemStack(getBlock(Info.cosmetics), 2, 0), new AspectList().add(Aspect.EARTH, 2).add(Aspect.FIRE, 2), new Object[] { " i ", "oeo", " i ", 'i', new ItemStack(Item.dyePowder, 1, 0), 'e', Item.enderPearl, 'o', new ItemStack(getBlock(Info.cosmetics), 1, 1) } ));
	}

	static void addWorkbenchRecipes()
	{
		addOreDictRecipes("ThaumiumHammer", new ItemStack(Registries.hammerThaum, 1, 0), new Object[] { " t ", " st", "s  ", 's', "stickWood", 't', new ItemStack(getItem(Info.resources), 1, 2)});
	}
	
	static void addOreDictRecipes(String name, ItemStack stack, Object[] recipe)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(stack, recipe));
		List<IRecipe> irecipe = CraftingManager.getInstance().getRecipeList();
		ConfigResearch.recipes.put(name, irecipe.get(irecipe.size() -1));
	}

	static void addAspectstoNihilo() 
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

	static void addPages()
	{
		ResearchCategories.registerCategory("SKYCHEMY", new ResourceLocation("exaliquo:textures/misc/thaumicpage.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
	}
	
	static void changePrimalWands()
	{
		exaliquo.logger.log(Level.INFO, "Changing Primal Aspect Wand and Staff Recipes");
		
		String[] infusionName = { "ROD_obsidian", "ROD_ice", "ROD_quartz", "ROD_reed", "ROD_blaze", "ROD_bone", "ROD_silverwood", "ROD_primal_staff"};
		String[] infusionRecipe = { "WandRodObsidian", "WandRodIce", "WandRodQuartz", "WandRodReed", "WandRodBlaze", "WandRodBone", "WandRodSilverwood", "WandRodPrimalStaff"};
		
		String[] arcaneName = { "ROD_greatwood_staff", "ROD_obsidian_staff", "ROD_ice_staff", "ROD_quartz_staff", "ROD_reed_staff", "ROD_blaze_staff", "ROD_bone_staff", "ROD_silverwood_staff" };
		String[] arcaneRecipe = { "WandRodGreatwoodStaff", "WandRodObsidianStaff", "WandRodIceStaff", "WandRodQuartzStaff", "WandRodReedStaff", "WandRodBlazeStaff", "WandRodBoneStaff", "WandRodSilverwoodStaff" };
		String[] staffshape = { "  f", " g ", "s  " };
		
		InfusionRecipe[] oldInfusion = {
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 1)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 3)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 4)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 5)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 6)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 7)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 2)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 100))
				}; //Obsidian, Ice, Quartz, Reed, Blaze, Bone, Silverwood, Primal
		
		InfusionRecipe[] newInfusion = {
				new InfusionRecipe(oldInfusion[0].research, oldInfusion[0].recipeOutput, oldInfusion[0].instability, oldInfusion[0].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 3), new ItemStack(Block.obsidian) }),
				new InfusionRecipe(oldInfusion[1].research, oldInfusion[1].recipeOutput, oldInfusion[1].instability, oldInfusion[1].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 2), new ItemStack(Block.ice) }),
				new InfusionRecipe(oldInfusion[2].research, oldInfusion[2].recipeOutput, oldInfusion[2].instability, oldInfusion[2].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 4), new ItemStack(Block.blockNetherQuartz) }),
				new InfusionRecipe(oldInfusion[3].research, oldInfusion[3].recipeOutput, oldInfusion[3].instability, oldInfusion[3].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 0), new ItemStack(Item.reed) }),
				new InfusionRecipe(oldInfusion[4].research, oldInfusion[4].recipeOutput, oldInfusion[4].instability, oldInfusion[4].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 1), new ItemStack(Item.blazeRod) }),
				new InfusionRecipe(oldInfusion[5].research, oldInfusion[5].recipeOutput, oldInfusion[5].instability, oldInfusion[5].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 5), new ItemStack(Item.bone) }),
				new InfusionRecipe(oldInfusion[6].research, oldInfusion[6].recipeOutput, oldInfusion[6].instability, oldInfusion[6].aspects, new ItemStack(getItem(Info.magicwood), 1, 1), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.wands), 1, 5), new ItemStack(getItem(Info.wands), 1, 6), new ItemStack(getItem(Info.wands), 1, 3), new ItemStack(getItem(Info.wands), 1, 0), new ItemStack(getItem(Info.wands), 1, 1), new ItemStack(getItem(Info.wands), 1, 4), new ItemStack(getItem(Info.wands), 1, 7) }),
				new InfusionRecipe(oldInfusion[7].research, oldInfusion[7].recipeOutput, oldInfusion[7].instability, oldInfusion[7].aspects, new ItemStack(getItem(Info.wands), 1, 52), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 15), new ItemStack(getItem(Info.wands), 1, 51), new ItemStack(getItem(Info.wands), 1, 53), new ItemStack(getItem(Info.wands), 1, 54), new ItemStack(getItem(Info.resources), 1, 15), new ItemStack(getItem(Info.wands), 1, 55), new ItemStack(getItem(Info.wands), 1, 56), new ItemStack(getItem(Info.wands), 1, 57) })
		};
		
		IArcaneRecipe[] oldArcane = {
				getArcaneRecipe("ROD_greatwood_staff"),
				getArcaneRecipe("ROD_obsidian_staff"),
				getArcaneRecipe("ROD_ice_staff"),
				getArcaneRecipe("ROD_quartz_staff"),
				getArcaneRecipe("ROD_reed_staff"),
				getArcaneRecipe("ROD_blaze_staff"),
				getArcaneRecipe("ROD_bone_staff"),
				getArcaneRecipe("ROD_silverwood_staff")
		};
		
		IArcaneRecipe[] newArcane = {
				new ShapedArcaneRecipe(oldArcane[0].getResearch(), oldArcane[0].getRecipeOutput(), oldArcane[0].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 0), 's', new ItemStack(getItem(Info.wands), 1, 2) }),
				new ShapedArcaneRecipe(oldArcane[1].getResearch(), oldArcane[1].getRecipeOutput(), oldArcane[1].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 1), 's', new ItemStack(getItem(Info.wands), 1, 50) }),
				new ShapedArcaneRecipe(oldArcane[2].getResearch(), oldArcane[2].getRecipeOutput(), oldArcane[2].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 3), 's', new ItemStack(getItem(Info.wands), 1, 50) }),
				new ShapedArcaneRecipe(oldArcane[3].getResearch(), oldArcane[3].getRecipeOutput(), oldArcane[3].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 4), 's', new ItemStack(getItem(Info.wands), 1, 50) }),
				new ShapedArcaneRecipe(oldArcane[4].getResearch(), oldArcane[4].getRecipeOutput(), oldArcane[4].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 5), 's', new ItemStack(getItem(Info.wands), 1, 50) }),
				new ShapedArcaneRecipe(oldArcane[5].getResearch(), oldArcane[5].getRecipeOutput(), oldArcane[5].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 6), 's', new ItemStack(getItem(Info.wands), 1, 50) }),
				new ShapedArcaneRecipe(oldArcane[6].getResearch(), oldArcane[6].getRecipeOutput(), oldArcane[6].getAspects(), new Object[] { staffshape, 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 7), 's', new ItemStack(getItem(Info.wands), 1, 50) }),
				new ShapedArcaneRecipe(oldArcane[7].getResearch(), oldArcane[7].getRecipeOutput(), oldArcane[7].getAspects(), new Object[] { " gf", "gsg", "sg ", 'f', new ItemStack(getItem(Info.resources), 1, 15), 'g', new ItemStack(getItem(Info.wands), 1, 50), 's', new ItemStack(getItem(Info.wands), 1, 2) })
		};
		
		for (int i = 0; i < infusionRecipe.length; i++)
		{
			ConfigResearch.recipes.put(infusionRecipe[i], newInfusion[i]);
		}
		for (int i = 0; i < arcaneRecipe.length; i++)
		{
			ConfigResearch.recipes.put(arcaneRecipe[i], newArcane[i]);
		}
		
		try
		{
			//Reflectionstuff Start
			Field recipes = Class.forName("thaumcraft.api.ThaumcraftApi").getDeclaredField("craftingRecipes");
			recipes.setAccessible(true);
			ArrayList oldList = (ArrayList) recipes.get(oldInfusion[0]);
			for (int i = 0; i < oldInfusion.length; i++)
			{
				oldList.set(oldList.indexOf(oldInfusion[i]), newInfusion[i]);
			}
			for (int i = 0; i < oldArcane.length; i++)
			{
				oldList.set(oldList.indexOf(oldArcane[i]), newArcane[i]);
			}
			recipes.set(recipes, oldList);
			//Reflectionstuff End
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ResearchItem[] infusionResearch = {
				copyResearch(ResearchCategories.getResearch(infusionName[0])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_obsidian.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodObsidian")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[1])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_ice.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodIce")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[2])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_quartz.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodQuartz")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[3])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_reed.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodReed")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[4])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_blaze.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodBlaze")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[5])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_bone.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodBone")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[6])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_silverwood.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodSilverwood")) }),
				copyResearch(ResearchCategories.getResearch(infusionName[7])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_primal_staff.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodPrimalStaff")) })
		};
		
		ResearchItem[] arcaneResearch = {
				copyResearch(ResearchCategories.getResearch(arcaneName[0])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_greatwood_staff.1"), new ResearchPage("tc.research_page.ROD_greatwood_staff.2"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodGreatwoodStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[1])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_obsidian_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodObsidianStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[2])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_ice_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodIceStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[3])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_quartz_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodQuartzStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[4])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_reed_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodReedStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[5])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_blaze_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodBlazeStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[6])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_bone_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodBoneStaff")) }),
				copyResearch(ResearchCategories.getResearch(arcaneName[7])).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_silverwood_staff.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("WandRodSilverwoodStaff")) })
		};
		
		for (int i = 0; i < infusionResearch.length; i++)
		{
			removeResearch(infusionName[i]);
			infusionResearch[i].registerResearchItem();
		}
		for (int i = 0; i < arcaneResearch.length; i++)
		{
			removeResearch(arcaneName[i]);
			arcaneResearch[i].registerResearchItem();
		}
	}
	
	private static void removeResearch(String research)
	{
		Collection researchcategory = ResearchCategories.researchCategories.values();
		for (Object obj : researchcategory)
		{
			Collection researchlist = ((ResearchCategoryList)obj).research.values();
			for (Object researchitem : researchlist)
			{
				if (((ResearchItem)researchitem).key.equals(research))
				{
					researchlist.remove(researchitem);
					break;
				}
			}
		}
	}
	
	private static ResearchItem copyResearch(ResearchItem research)
	{
		String k = research.key;
		String cat = research.category;
		AspectList as = research.tags;
		int col = research.displayColumn;
		int row = research.displayRow;
		int complex = research.getComplexity();
		ItemStack icon = research.icon_item;
		
		ResearchItem override = new ResearchItem(research.key, research.category, research.tags, research.displayColumn, research.displayRow, research.getComplexity(), research.icon_item);
		//override.setPages(research.getPages());
		if (research.isAutoUnlock()) override.setSpecial();
		if (research.isConcealed()) override.setStub();
		if (research.isHidden()) override.setHidden();
		if (research.isRound()) override.setRound();
		if (research.isSecondary()) override.setSecondary();
		if (research.isStub()) override.setStub();
		if (research.isVirtual()) override.setVirtual();
		override.setSiblings(research.siblings);
		override.setParents(research.parents);
		override.setParentsHidden(research.parentsHidden);
		override.setAspectTriggers(research.getAspectTriggers());
		override.setItemTriggers(research.getItemTriggers());
		
		return override;
	}
	
	private static IArcaneRecipe getArcaneRecipe(String research)
	{
		for (Object recipe : ThaumcraftApi.getCraftingRecipes())
		{
			if (recipe instanceof IArcaneRecipe)
			{
				if (((IArcaneRecipe)recipe).getResearch().equals(research))
				{
					return (IArcaneRecipe) recipe;
				}
			}
		}
		return null;
	}
}
