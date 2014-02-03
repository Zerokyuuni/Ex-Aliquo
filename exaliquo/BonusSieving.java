package exaliquo;

import tconstruct.common.TContent;
import net.minecraft.block.Block;
import exnihilo.registries.SieveRegistry;

public class BonusSieving {

	public static void addTinkerToSieves() {
		//SieveRegistry.register(Block.gravel.blockID, 0, Block.tnt.blockID, 0, 1); //WYNAUT
		if (Configurations.sieveOreBushes)
		{
			SieveRegistry.register(Block.dirt.blockID, 0, TContent.oreBerry.blockID, 8, 256);
			SieveRegistry.register(Block.dirt.blockID, 0, TContent.oreBerry.blockID, 9, 256);
			SieveRegistry.register(Block.dirt.blockID, 0, TContent.oreBerry.blockID, 10, 256);
			SieveRegistry.register(Block.dirt.blockID, 0, TContent.oreBerry.blockID, 11, 256);
			SieveRegistry.register(Block.dirt.blockID, 0, TContent.oreBerrySecond.blockID, 8, 256);
		}
		if (Configurations.sieveEssenceBushes)
		{
			SieveRegistry.register(Block.dirt.blockID, 0, TContent.oreBerrySecond.blockID, 9, 128);
		}
		if (Configurations.sieveAluminum)
		{
		SieveRegistry.register(Block.gravel.blockID, 0, TContent.materials.itemID, 22, 3); //Aluminum
		}
		if (Configurations.sieveNetherOres)
		{
		SieveRegistry.register(Block.slowSand.blockID, 0, TContent.materials.itemID, 28, 64); //Cobalt
		SieveRegistry.register(Block.slowSand.blockID, 0, TContent.materials.itemID, 29, 64); //Ardite
		}
	}
}
