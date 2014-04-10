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
import exaliquo.bridges.ArsMagica.ArsMagica;
import exaliquo.bridges.Dart.Dartcraft;
import exaliquo.bridges.Growthcraft.Growthcraft;
import exaliquo.bridges.Mariculture.AliquoFish;
import exaliquo.bridges.Mariculture.Mariculture;
import exaliquo.bridges.Metallurgy.Metallurgy;
import exaliquo.bridges.MineFactoryReloaded.MineFactoryReloaded;
import exaliquo.bridges.Natura.Natura;
import exaliquo.bridges.TConstruct.TConstruct;
import exaliquo.bridges.Thaumcraft.ExThaumiquo;
import exaliquo.bridges.Thaumcraft.Thaumcraft;
import exaliquo.bridges.crossmod.Crossmod;
import exaliquo.data.Colors;
import exaliquo.data.Configurations;
import exaliquo.data.ExATab;
import exaliquo.proxy.ForestryReflection;
import static exaliquo.data.ModsLoaded.*;

@Mod(modid = "exaliquo", name = "Ex Aliquo", version = "0.10.5", dependencies = "required-after:crowley.skyblock@[1.26b,);after:TConstruct@(1.5.2,];after:Natura@[2.1.14,);after:arsmagica2;after:Thaumcraft@[4.1,);after:Growthcraft|Apples;after:Growthcraft|Bamboo;after:Growthcraft|Bees;after:Growthcraft|Grapes;after:Growthcraft|Hops;after:Growthcraft|Rice;after:Mariculture;after:MineFactoryReloaded;after:NetherOres;after:Metallurgy3Base;after:ExtraTiC;after:Forestry;after:ExtraTrees;after:pamharvestcraft")
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
			Registries.registerNihiloOreDict();
		}
		GeneralAliquo.initGeneralStuff();
		Crossmod.initCross();
		if (isTConLoaded || Configurations.registerTConstruct)
		{
			Registries.registerExTConstructOres();
		}
		if (isTConLoaded)
		{
			exaliquo.logger.log(Level.INFO,"Loading Tinker's Construct Compat");
			TConstruct.initTConstruct();
		}
		if (isNaturaLoaded)
		{
			exaliquo.logger.log(Level.INFO,"Loading Natura Compat");
			Natura.initNatura();
		}
		if (isArsMagicaLoaded)
		{
			exaliquo.logger.log(Level.INFO,"Loading Ars Magica 2 Compat");
			ArsMagica.initArsMagica();
		}
		if (isThaumcraftLoaded)
		{
			exaliquo.logger.info("Loading Thaumcraft 4 Compat");
			Thaumcraft.initThaumcraft();
		}
		if(isGrowthcraftLoaded)
		{
			exaliquo.logger.info("Loading Growthcraft Compat");
			Growthcraft.initGrowthcraft();
		}
		if (isMaricultureLoaded)
		{
			exaliquo.logger.info("Loading Mariculture Compat");
			Mariculture.initMariculture();
		}
		if (isMFRLoaded)
		{
			exaliquo.logger.info("Loading MFR Compat");
			MineFactoryReloaded.initMFR();
		}
		if (isMetallurgyLoaded || Configurations.registerMetallurgy)
		{
			Registries.registerExMetallurgyOres();
		}
		if (isMetallurgyLoaded)
		{
			exaliquo.logger.info("Loading Metallurgy Compat");
			Metallurgy.initMetallurgy();
		}
		if (isDartcraftLoaded)
		{
			exaliquo.logger.info("Loading Dartcraft Compat");
			Dartcraft.initDartcraft();
		}
		if (isForestryLoaded)
		{
			ForestryReflection.initProxy();
		}
	}
}
