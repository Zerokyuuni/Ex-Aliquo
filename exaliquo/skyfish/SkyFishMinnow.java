package exaliquo.Skyfish; 

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
}