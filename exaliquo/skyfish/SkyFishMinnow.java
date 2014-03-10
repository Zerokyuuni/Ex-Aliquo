package exaliquo.skyfish; 

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import mariculture.api.fishery.EnumRodQuality;
import mariculture.fishery.fish.FishMinnow;
import exaliquo.SkyFish;

public class SkyFishMinnow extends FishMinnow
{
	private Icon theIcon;

	public SkyFishMinnow(int id)
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
		if(quality.getRank() >= getRodNeeded().getRank() && rand.nextInt(100) < (getCatchChance() / (getGroup().canLive(world, x, y, z)?1:2)))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void onConsumed(World world, EntityPlayer player)
	{
		if (SkyFish.tastyfish)
		{
			player.getFoodStats().addStats(1, 0.05F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		}
		else
		{
			player.getFoodStats().addStats(1, 0.3F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		}
	}
}