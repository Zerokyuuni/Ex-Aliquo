package exaliquo.bridges.Mariculture.SkyFish; 

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import mariculture.api.fishery.EnumRodQuality;
import mariculture.api.fishery.Fishing;
import mariculture.fishery.fish.FishDragon;
import exaliquo.bridges.Mariculture.AliquoFish;
import exaliquo.data.Configurations;

public class SkyFishDragon extends FishDragon
{
	public SkyFishDragon(int id)
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
	public boolean canLive(World world, int x, int y, int z)
	{
		return getGroup().canLive(world, x, y, z);
	}
}