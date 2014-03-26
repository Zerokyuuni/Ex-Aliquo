package exaliquo.Skyfish; 

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import mariculture.api.fishery.EnumRodQuality;
import mariculture.api.fishery.Fishing;
import mariculture.core.helpers.BlockHelper;
import mariculture.core.util.Rand;
import mariculture.fishery.fish.FishEnder;
import exaliquo.SkyFish;
import exaliquo.data.Configurations;

public class SkyFishEnder extends FishEnder
{
	public SkyFishEnder(int id)
	{
		super(id);
	}
	
	@Override
	public String getSpecies()
	{
		return this.getClass().getSimpleName().toLowerCase().substring(7);
	}
	
	@Override
	public boolean canCatch(Random rand, World world, int x, int y, int z, EnumRodQuality quality)
	{
		if (Configurations.endOverride)
		{
			if(quality.getRank() >= getRodNeeded().getRank() && rand.nextInt(100) < (getCatchChance() / (getGroup().canLive(world, x, y, z)?1:2)))
			{
				return true;
			}
		}
		else
		{
			if(isWorldCorrect(world) && quality.getRank() >= getRodNeeded().getRank() && rand.nextInt(100) < getCatchChance())
			{
				return Fishing.fishHelper.biomeMatches(world.getWorldChunkManager().getBiomeGenAt(x, z), getGroup().getBiomes());
			}
		}
		return false;
	}
	
	@Override
	public int getCatchChance()
	{
		return Configurations.endOverride?5:25;
	}
	
	@Override
	public boolean canLive(World world, int x, int y, int z)
	{
		return getGroup().canLive(world, x, y, z);
	}
}