package exaliquo.bridges.crossmod;

import static exaliquo.data.ModIDs.getIDs;

import java.util.Arrays;

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
		if (Configurations.ninjaFeesh)
		{
			register(getIDs(Info.hellfeesh), 0, 0, 0, 0.0F, 0.0F);
			
			if (Configurations.whenk)
			{
				ThaumcraftApi.registerObjectTag(Block.netherrack.blockID, 0, null);
			}
			else
			{
				AspectList rack = (AspectList)ThaumcraftApi.objectTags.get(Arrays.asList(new Integer[] { Integer.valueOf(Block.netherrack.blockID), Integer.valueOf(-1) }));
				ThaumcraftApi.registerObjectTag(getIDs(Info.hellfeesh), 0, rack);
				//ThaumcraftApi.registerObjectTag(getIDs(Info.hellfeesh), 0, new AspectList().add(Aspect.FIRE, 1).add(Aspect.STONE, 1).add(Aspect.EARTH, 1));
			}
		}
	}
}
