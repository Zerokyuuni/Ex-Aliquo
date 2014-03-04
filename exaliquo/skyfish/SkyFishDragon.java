package exaliquo.skyfish; 

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import mariculture.api.fishery.EnumRodQuality;
import mariculture.api.fishery.Fishing;
import mariculture.fishery.fish.FishDragon;
import exaliquo.SkyFish;
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
	
	@Override
	public void onConsumed(World world, EntityPlayer player)
	{
		if (SkyFish.tastyfish)
		{
			player.getFoodStats().addStats(3, 0.7F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 1));
		}
		else
		{
			player.getFoodStats().addStats(12, 0.5F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 2000, 0));
		}
	}
}