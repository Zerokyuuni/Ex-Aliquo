package exaliquo;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "exaliquo", name = "Ex Aliquo 1.6.4", version = "0.8", dependencies = "required-after:crowley.skyblock@[1.23,);after:TConstruct;after:Natura@[2.1.14,);after:arsmagica2;after:Thaumcraft@[4.1,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class exaliquo {

	@Instance("exaliquo")
	public static exaliquo instance;
	
	public static final Logger logger = Logger.getLogger("exaliquo");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configurations.Load(event.getModConfigurationDirectory());
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
		if (Loader.isModLoaded("TConstruct"))
		{
			exaliquo.logger.log(Level.INFO,"Loading Tinker's Construct Compat");
			BonusSieving.addTinkerToSieves();
			MoltenMetals.addToSmelting();
			Colors.registerTinkerColors();
			ExtraCompost.registerTinkerCompost();
		}
		if (Loader.isModLoaded("Natura"))
		{
			exaliquo.logger.log(Level.INFO,"Loading Natura Compat");
			BonusSieving.addNaturaToSieves();
			Colors.registerNaturaColors();
			ExtraCompost.registerNaturaCompost();
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
			if (Loader.isModLoaded("TConstruct") && (Configurations.WYNAUT))
			{
				exaliquo.logger.log(Level.INFO,"What's better than a single Wobbuffet? ALL THE WYNAUT");
				MoltenMetals.WYNAUT();
			}
		}
		if (Loader.isModLoaded("Thaumcraft"))
		{
			exaliquo.logger.info("Loading Thaumcraft 4 Compat");
			Registries.registerThaumItems();
			ExThaumiquo.addAspectstoNihilo();
			ExThaumiquo.addCrucibleRecipes();
			ExThaumiquo.addWorkbenchRecipes();
			ExThaumiquo.addInfusionRecipes();
			ExThaumiquo.addPages();
			ExThaumiquo.addResearch();
			BonusSieving.addThaumcraftToSieves();
			BonusHammerTime.addThaumcraftToMCHammer();
		}
	}
}
