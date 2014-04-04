package exaliquo.bridges.crossmod;

import static exaliquo.data.ModIDs.getIDs;

import java.util.Arrays;

import powercrystals.netherores.NetherOresCore;

import net.minecraft.block.Block;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HammerRegistry.register;

public class NetherOres_Thaumcraft
{
	protected static void Whenk()
	{
			if (Configurations.whenk && Configurations.ninjaFeesh)
			{
				ThaumcraftApi.registerObjectTag(Block.netherrack.blockID, 0, null);
			}
			else
			{
				AspectList rack = (AspectList)ThaumcraftApi.objectTags.get(Arrays.asList(new Integer[] { Integer.valueOf(Block.netherrack.blockID), Integer.valueOf(-1) }));
				ThaumcraftApi.registerObjectTag(NetherOresCore.blockHellfish.blockID, 0, rack);
			}
	}
}
