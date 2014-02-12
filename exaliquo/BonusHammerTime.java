package exaliquo;

import net.minecraft.block.Block;
import exnihilo.registries.HammerRegistry;

import static exaliquo.ModIDs.getIDs;
import exaliquo.ModIDs.Info;

public class BonusHammerTime {

	private static final int stone = Block.stone.blockID;
	private static final int stonebrick = Block.stoneBrick.blockID;
	private static final int netherrack = Block.netherrack.blockID;
	private static final int netherbrick = Block.netherBrick.blockID;
	
	public static void addArstoMCHammer()
	{
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 0, 0.15F, 0.05F);		//Vinteum
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 4, 0.1F, 0.05F);		//Chimerite
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 5, 0.08F, 0.05F);		//Blue Topaz
		if (Configurations.hammerMoonstone)
		{
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 7, 0.05F, 0.05F);		//Moonstone
		}
		HammerRegistry.register(netherrack, 0, getIDs(Info.magicore), 6, 0.05F, 0.05F);	//Sunstone		
	}
}
