package exaliquo.skyfish; 

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
	
	@Override
	public void onConsumed(World world, EntityPlayer player)
	{
		if (SkyFish.tastyfish)
		{
			player.getFoodStats().addStats(1, -0.05F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			if(!world.isRemote)
			{
				world.playSoundEffect(player.posX, player.posY, player.posZ, "mob.endermen.portal", 1.0F, 1.0F);
				int x = (int) ((player.posX) + Rand.rand.nextInt(64) - 32);
				int z = (int) ((player.posZ) + Rand.rand.nextInt(64) - 32);
				if(BlockHelper.chunkExists(world, x, z))
				{
					int y = world.getTopSolidOrLiquidBlock(x, z);
					if(world.getBlockMaterial(x, y, z) != Material.lava)
					{
						world.playSoundEffect(x, y, z, "mob.endermen.portal", 1.0F, 1.0F);
						player.setPositionAndUpdate(x, y, z);
						world.playSoundEffect(player.posX, player.posY, player.posZ, "mob.endermen.portal", 1.0F, 1.0F);
					}
				}
			}
		}
		else
		{
			player.getFoodStats().addStats(2, -0.1F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			if(!world.isRemote)
			{
				world.playSoundEffect(player.posX, player.posY, player.posZ, "mob.endermen.portal", 1.0F, 1.0F);
				int x = (int) ((player.posX) + Rand.rand.nextInt(64) - 32);
				int z = (int) ((player.posZ) + Rand.rand.nextInt(64) - 32);
				if(BlockHelper.chunkExists(world, x, z))
				{
					int y = world.getTopSolidOrLiquidBlock(x, z);
					if(world.getBlockMaterial(x, y, z) != Material.lava)
					{
						world.playSoundEffect(x, y, z, "mob.endermen.portal", 1.0F, 1.0F);
						player.setPositionAndUpdate(x, y, z);
						world.playSoundEffect(player.posX, player.posY, player.posZ, "mob.endermen.portal", 1.0F, 1.0F);
					}
				}
			}
		}
	}
}