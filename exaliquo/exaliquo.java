package exaliquo;

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

@Mod(modid = "exaliquo", name = "Ex Aliquo 1.6.4", version = "0.7", dependencies = "required-after:crowley.skyblock@[1.23,);after:TConstruct;after:Natura;after:arsmagica2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class exaliquo {

	@Instance("exaliquo")
	public static exaliquo instance;
	
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
			BonusSieving.addTinkerToSieves();
			MoltenMetals.addToSmelting();
			Colors.registerTinkerColors();
			ExtraCompost.registerTinkerCompost();
		}
		if (Loader.isModLoaded("Natura"))
		{
			BonusSieving.addNaturaToSieves();
			Colors.registerNaturaColors();
			ExtraCompost.registerNaturaCompost();
		}
		if (Loader.isModLoaded("arsmagica2"))
		{
			if (Configurations.sieveNovas)
			{
			BonusSieving.addArsToSieves();
			}
			EssenceRefining.addNihiloToArs();
			BonusHammerTime.addArstoMCHammer();
			Colors.registerArsColors();
			ExtraCompost.registerArsCompost();
			if (Loader.isModLoaded("TConstruct"))
			{
				MoltenMetals.WYNAUT();
			}
		}
	}
}
