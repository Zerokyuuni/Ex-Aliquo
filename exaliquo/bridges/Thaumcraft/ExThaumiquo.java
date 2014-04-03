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
					new AspectList().add(Aspect.TOOL, 0).add(Aspect.AIR, 0),
					3,
					4,
					0,
					new ItemStack(getBlock(Info.devices), 1, 2)).setPages(new ResearchPage[] {
							new ResearchPage("exa.page.SKYMATRIX.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("SkyMatrix"))
					}).setParentsHidden("INFUSION").setConcealed().registerResearchItem();
			
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
				}).setParentsHidden("THAUMIUM").setConcealed().registerResearchItem();
		
		new ExAResearchItem("SKYFILTER",
				"SKYCHEMY",
				new AspectList().add(Aspect.TOOL, 0).add(Aspect.AIR, 0),
				3,
				3,
				0,
				new ItemStack(getItem(Info.resources), 1, 8)).setPages(new ResearchPage[] {
						new ResearchPage("exa.page.SKYFILTER.1"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("Skyfilter"))
				}).setParentsHidden("DISTILESSENTIA").setConcealed().registerResearchItem();
		
		new ExAResearchItem("OBSIDIANTOTEM",
				"SKYCHEMY",
				new AspectList().add(Aspect.ELDRITCH, 6).add(Aspect.STONE, 12).add(Aspect.DARKNESS, 6),
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
		exaliquo.logger.log(Level.INFO, "Changing Primal Aspect Wand Recipes");
		InfusionRecipe[] oldWands = {
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 1)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 3)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 4)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 5)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 6)),
				ThaumcraftApi.getInfusionRecipe(new ItemStack(getItem(Info.wands), 1, 7))
				};
		
		InfusionRecipe[] newWands = {
				new InfusionRecipe(oldWands[0].research, oldWands[0].recipeOutput, oldWands[0].instability, oldWands[0].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 3), new ItemStack(Block.obsidian) }),
				new InfusionRecipe(oldWands[1].research, oldWands[1].recipeOutput, oldWands[1].instability, oldWands[1].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 2), new ItemStack(Block.ice) }),
				new InfusionRecipe(oldWands[2].research, oldWands[2].recipeOutput, oldWands[2].instability, oldWands[2].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 4), new ItemStack(Block.blockNetherQuartz) }),
				new InfusionRecipe(oldWands[3].research, oldWands[3].recipeOutput, oldWands[3].instability, oldWands[3].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 0), new ItemStack(Item.reed) }),
				new InfusionRecipe(oldWands[4].research, oldWands[4].recipeOutput, oldWands[4].instability, oldWands[4].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 1), new ItemStack(Item.blazeRod) }),
				new InfusionRecipe(oldWands[5].research, oldWands[5].recipeOutput, oldWands[5].instability, oldWands[5].aspects, new ItemStack(getItem(Info.wands), 1, 0), new ItemStack[] { new ItemStack(getItem(Info.resources), 1, 14), new ItemStack(getItem(Info.shard), 1, 5), new ItemStack(Item.bone) })
		};
		
		String[] wandNames = { "ROD_reed", "ROD_blaze", "ROD_obsidian", "ROD_ice", "ROD_quartz", "ROD_bone" };

		try
		{
			ConfigResearch.recipes.put("WandRodObsidian", newWands[0]);
			ConfigResearch.recipes.put("WandRodIce", newWands[1]);
			ConfigResearch.recipes.put("WandRodQuartz", newWands[2]);
			ConfigResearch.recipes.put("WandRodReed", newWands[3]);
			ConfigResearch.recipes.put("WandRodBlaze", newWands[4]);
			ConfigResearch.recipes.put("WandRodBone", newWands[5]);
			
			Field field = Class.forName("thaumcraft.api.ThaumcraftApi").getDeclaredField("craftingRecipes");
			field.setAccessible(true);
			ArrayList al = (ArrayList) field.get(oldWands[0]);
			for (int i = 0; i < oldWands.length; i++)
			{
				al.set(al.indexOf(oldWands[i]), newWands[i]);
				removeResearch(wandNames[i]);
			}
			field.set(field, al);
			
		    new ResearchItem("ROD_obsidian", "THAUMATURGY", new AspectList().add(Aspect.TOOL, 5).add(Aspect.EARTH, 8).add(Aspect.STONE, 5).add(Aspect.MAGIC, 5), -8, 2, 2, new ItemStack(getItem(Info.wands), 1, 1)).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_obsidian.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodObsidian")) }).setSecondary().setConcealed().setParents(new String[] { "ROD_greatwood", "INFUSION" }).registerResearchItem();
		    new ResearchItem("ROD_reed", "THAUMATURGY", new AspectList().add(Aspect.TOOL, 5).add(Aspect.AIR, 8).add(Aspect.PLANT, 5).add(Aspect.MAGIC, 5), -5, -1, 2, new ItemStack(getItem(Info.wands), 1, 5)).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_reed.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodReed")) }).setSecondary().setConcealed().setParents(new String[] { "ROD_greatwood", "INFUSION" }).registerResearchItem();
		    new ResearchItem("ROD_blaze", "THAUMATURGY", new AspectList().add(Aspect.TOOL, 5).add(Aspect.FIRE, 8).add(Aspect.ENERGY, 5).add(Aspect.MAGIC, 5), -7, 0, 2, new ItemStack(getItem(Info.wands), 1, 6)).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_blaze.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodBlaze")) }).setSecondary().setConcealed().setParents(new String[] { "ROD_greatwood", "INFUSION" }).registerResearchItem();
		    new ResearchItem("ROD_ice", "THAUMATURGY", new AspectList().add(Aspect.TOOL, 5).add(Aspect.ICE, 8).add(Aspect.WATER, 5).add(Aspect.MAGIC, 5), -7, 4, 2, new ItemStack(getItem(Info.wands), 1, 3)).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_ice.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodIce")) }).setSecondary().setConcealed().setParents(new String[] { "ROD_greatwood", "INFUSION" }).registerResearchItem();
		    new ResearchItem("ROD_quartz", "THAUMATURGY", new AspectList().add(Aspect.TOOL, 5).add(Aspect.ORDER, 8).add(Aspect.CRYSTAL, 5).add(Aspect.MAGIC, 5), -5, 5, 2, new ItemStack(getItem(Info.wands), 1, 4)).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_quartz.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodQuartz")) }).setSecondary().setConcealed().setParents(new String[] { "ROD_greatwood", "INFUSION" }).registerResearchItem();
		    new ResearchItem("ROD_bone", "THAUMATURGY", new AspectList().add(Aspect.TOOL, 5).add(Aspect.ENTROPY, 8).add(Aspect.UNDEAD, 5).add(Aspect.MAGIC, 5), -3, 0, 2, new ItemStack(getItem(Info.wands), 1, 7)).setPages(new ResearchPage[] { new ResearchPage("tc.research_page.ROD_bone.1"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("WandRodBone")) }).setSecondary().setConcealed().setParents(new String[] { "ROD_greatwood", "INFUSION" }).registerResearchItem();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private static void removeResearch(String research)
	{
		ResearchItem researchname = ResearchCategories.getResearch(research);
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
}
