package exaliquo.skyfish; 

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import mariculture.api.fishery.EnumRodQuality;
import mariculture.api.fishery.Fishing;
import mariculture.fishery.fish.FishNight;
import exaliquo.SkyFish;
import exaliquo.data.Configurations;

public class SkyFishNight extends FishNight
{
	public SkyFishNight(int id)
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
		return Configurations.endOverride?35:65;
	}
	
	@Override
	public boolean canLive(World world, int x, int y, int z)
	{
		return getGroup().canLive(world, x, y, z);
	}
	
	@Override
	public void onConsumed(World world, EntityPlayer player)
	{
		if (SkyFish.tastyfish)
		{
			if (!world.isDaytime())
			{
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1800, 0));
			}
			player.getFoodStats().addStats(0, 0.05F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			}
		else
		{
			if (!world.isDaytime())
			{
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1800, 0));
			}
			player.getFoodStats().addStats(1, 1F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		}
	}
}