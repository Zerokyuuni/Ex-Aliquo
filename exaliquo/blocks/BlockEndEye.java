package exaliquo.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exaliquo.Registries;
import exaliquo.data.AliquoTickHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndEye extends Block
{

	@SideOnly(Side.CLIENT)
	private Icon[] icon;
	private Random rand = new Random();
	@SideOnly(Side.CLIENT)
	private int eye;
	private boolean allow = true;
	
	public BlockEndEye(int id) {
		super(id, Material.rock);
		setHardness(2.5F);
		setResistance(15.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		icon = new Icon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon("exaliquo:EnderEye_" + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int id, int meta)
	{
		if (AliquoTickHandler.tick == 400 && allow)
		{
			allow = false;
			return icon[eyeBlink()];
		}
		if (AliquoTickHandler.tick > 20 && !allow)
		{
			allow = true;
			return icon[0];
		}
		else return icon[eye];
	}
	
	@Override
	public int tickRate(World world)
	{
		return 10;
	}
	
	@Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		int vel = rand.nextInt()*2-1;
		world.spawnParticle("portal", (double)(x*rand.nextFloat()), (double)(y*rand.nextFloat()), (double)(z*rand.nextFloat()), (double)((float)vel*rand.nextFloat()*1.0F), (double)((float)vel*rand.nextFloat()*1.0F), (double)((float)vel*rand.nextFloat()*1.0F));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		world.playSound((double)x+0.5D, (double)y+0.5D, (double)z+0.5D, "mob.endermen.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		return false;
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
    {
		world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote)
		{
			world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
			this.getBlockTexture(world, x, y, z, 0);
		}
		
		if (world.getBlockMetadata(x, y, z) == 0)
		{
			world.setBlock(x, y, z, this.blockID, 1, 2);
		}
		else
		{
			world.setBlock(x, y, z, this.blockID, 0, 2);
		}
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		if (AliquoTickHandler.tick < 10)
		{
			return icon[eyeBlink()];
		}
		return icon[0];
	}
	
	@SideOnly(Side.CLIENT)
	private int eyeBlink()
	{
		int i = rand.nextInt(999);
		switch (i/128)
		{
		case 2:
			eye = 1;
			return eye;
		case 3:
			eye = 2;
			return eye;
		default:
			eye = 0;
			return eye;
		}
	}
}
