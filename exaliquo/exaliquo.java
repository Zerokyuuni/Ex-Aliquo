package exaliquo;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import exaliquo.data.Colors;
import exaliquo.data.Configurations;

@Mod(modid = "exaliquo", name = "Ex Aliquo", version = "0.9.2", dependencies = "required-after:crowley.skyblock@[1.26b,);after:TConstruct;after:Natura@[2.1.14,);after:arsmagica2;after:Thaumcraft@[4.1,);after:Growthcraft|Apples;after:Growthcraft|Bamboo;after:Growthcraft|Bees;after:Growthcraft|Grapes;after:Growthcraft|Hops;after:Growthcraft|Rice;after:Mariculture;after:MineFactoryReloaded;after:NetherOres;after:Metallurgy3Base;after:ExtraTiC")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class exaliquo {

	@Instance("exaliquo")
	public static exaliquo instance;
	
	public static final Logger logger = Logger.getLogger("exaliquo");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configurations.Load(event.getModConfigurationDirectory());
		Registries.exatab = new ExATab("Ex Aliquo");
		Registries.registerItems();
		Registries.registerRecipes();
		Registries.exatab.initTab(new ItemStack(Registries.crookGold, 1, 0));
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (Configurations.isOre)
		{
			Registries.registerOreDict();
		}
		GeneralAliquo.registerGeneralCompost();
		GeneralAliquo.registerSieves();
		GeneralAliquo.registerHammering();
		if (Loader.isModLoaded("TConstruct") || Configurations.registerTConstruct)
		{
			Registries.registerExTConstructOres();
			BonusSieving.addTinkerOreToSieves();
			BonusHammerTime.addTinkerToMCHammer();
		}
		if (Loader.isModLoaded("TConstruct"))
		{
			exaliquo.logger.log(Level.INFO,"Loading Tinker's Construct Compat");
			BonusSieving.addTinkerToSieves();
			MoltenMetals.addToSmelting();
			Colors.registerTinkerColors();
			ExtraCompost.registerTinkerCompost();
			HotStuff.addTinkerFuels();
			Registries.addModifiers();
			Registries.addExTConstructOreDict();
		}
		if (Loader.isModLoaded("Natura"))
		{
			exaliquo.logger.log(Level.INFO,"Loading Natura Compat");
			BonusSieving.addNaturaToSieves();
			Colors.registerNaturaColors();
			ExtraCompost.registerNaturaCompost();
			Registries.addNaturaCrafting();
		}
		if (Loader.isModLoaded("arsmagica2"))
		{
			exaliquo.logger.log(Level.INFO,"Loading Ars Magica 2 Compat");
			if (Configurations.sieveNovas)
			{
			BonusSieving.addArsToSieves();
			}
			EssenceRefining.addNihiloToArs();
			BonusHammerTime.addArstoMCHammer();
			Colors.registerArsColors();
			ExtraCompost.registerArsCompost();
			HotStuff.addArsFuels();
			if (Loader.isModLoaded("TConstruct") && (Configurations.WYNAUT))
			{
				exaliquo.logger.log(Level.INFO,"What's better than a single Wobbuffet? ALL THE WYNAUT");
				MoltenMetals.WYNAUT();
			}
		}
		if (Loader.isModLoaded("Thaumcraft"))
		{
			exaliquo.logger.info("Loading Thaumcraft 4 Compat");
			ExThaumiquo.addAspectstoNihilo();
			ExThaumiquo.addCrucibleRecipes();
			ExThaumiquo.addArcaneRecipes();
			ExThaumiquo.addWorkbenchRecipes();
			ExThaumiquo.addInfusionRecipes();
			ExThaumiquo.addPages();
			ExThaumiquo.addResearch();
			BonusSieving.addThaumcraftToSieves();
			BonusHammerTime.addThaumcraftToMCHammer();
			HotStuff.addThaumicFuels();
			Colors.registerThaumicColors();
			ExtraCompost.registerThaumicCompost();
		}
		if(Loader.isModLoaded("Growthcraft|Apples"))
		{
			exaliquo.logger.info("Loading GC Apple Compat");
			ExtraCompost.registerGCAppleCompost();
		}
		if (Loader.isModLoaded("Growthcraft|Bamboo"))
		{
			exaliquo.logger.info("Loading GC Bamboo Compat");
			BonusSieving.addBambooToSieves();
			Colors.registerGCBambooColors();
			ExtraCompost.registerGCBambooCompost();
		}
		if (Loader.isModLoaded("Growthcraft|Bees"))
		{
			exaliquo.logger.info("Loading GC Bees Compat");
			BonusSieving.addBeesToSieves();
		}
		if (Loader.isModLoaded("Growthcraft|Grapes"))
		{
			exaliquo.logger.info("Loading GC Grapes Compat");
			Colors.registerGCGrapesColors();
			ExtraCompost.registerGCGrapesCompost();
		}
		if(Loader.isModLoaded("Growthcraft|Hops"))
		{
			exaliquo.logger.info("Loading GC Hops Compat");
			Colors.registerGCHopsColors();
			ExtraCompost.registerGCHopsCompost();
		}
		if(Loader.isModLoaded("Growthcraft|Rice"))
		{
			exaliquo.logger.info("Loading GC Rice Compat");
			ExtraCompost.registerGCRiceCompost();
		}
		if (Loader.isModLoaded("Mariculture"))
		{
			exaliquo.logger.info("Loading Mariculture Compat");
			BonusSieving.addMaricultureToSieves();
			SkyFish.overrideFish();
			SkyFish.addBooty();
		}
		if (Loader.isModLoaded("MineFactoryReloaded"))
		{
			exaliquo.logger.info("Loading MFR Compat");
			BonusSieving.addMFRToSieves();
			Colors.registerMFRColors();
			ExtraCompost.registerMFRCompost();
		}
		if (Loader.isModLoaded("Metallurgy3Base") || Configurations.registerMetallurgy)
		{
			exaliquo.logger.info("Loading Metallurgy Compat");
			Registries.registerExMetallurgyOres();
			BonusSieving.addMetallurgyToSieves();
			BonusHammerTime.addMetallurgyToMCHammer();
		}
		if (Loader.isModLoaded("Metallurgy3Base"))
		{
			Registries.registerExMetallurgySmelting();
			Registries.registerExMetallurgyCrafting();
			if (Configurations.isOre)
			{
				Registries.registerExMetallurgyOreDict();
			}
		}
		if (Loader.isModLoaded("ExtraTiC"))
		{
			MoltenMetals.addExMetallurgyToSmeltery();
		}
		if (Loader.isModLoaded("Dartcraft"))
		{
			Colors.registerDartcraftColors();
			ExtraCompost.registerDartcraftCompost();
		}
	}
}
