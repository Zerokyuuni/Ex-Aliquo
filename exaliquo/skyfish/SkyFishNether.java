package exaliquo.Skyfish; 

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import mariculture.api.fishery.EnumRodQuality;
import mariculture.api.fishery.Fishing;
import mariculture.fishery.fish.FishNether;
import exaliquo.SkyFish;

public class SkyFishNether extends FishNether
{
	public SkyFishNether(int id)
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
		if(isWorldCorrect(world) && quality.getRank() >= getRodNeeded().getRank() && rand.nextInt(100) < getCatchChance())
		{
			return Fishing.fishHelper.biomeMatches(world.getWorldChunkManager().getBiomeGenAt(x, z), getGroup().getBiomes());
		}
		return false;
	}
	
	@Override
	public boolean canLive(World world, int x, int y, int z) {
		return getGroup().canLive(world, x, y, z);
	}
}