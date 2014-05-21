package exaliquo.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEndCake extends BlockCake
{
	@SideOnly(Side.CLIENT)
	private Icon[] icon;
	
	public BlockEndCake(int id)
	{
		super(id);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		icon = new Icon[4];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon("exaliquo:EnderCake_" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return side == 0 ? icon[side] : (side == 1 ? icon[side] : (meta > 0 && side == 4 ? icon[3] : icon[2]));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		int meta = world.getBlockMetadata(x, y, z) - 1;
		ItemStack item = player.getCurrentEquippedItem();

		if (player.capabilities.isCreativeMode)
		{
			if (item != null && item.getItem() == Item.eyeOfEnder)
			{
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
				return true;
			}
			else
			{
				player.travelToDimension(1);
				return true;
			}
		}
		else
		{
			if (item != null && item.getItem() == Item.eyeOfEnder)
			{
				if (meta > 0)
				{
					world.setBlockMetadataWithNotify(x, y, z, meta, 2);
					--item.stackSize;
					return true;
				}
			}
			else
			{
				nomEndCake(world, x, y, z, player);
				return true;
			}
		}
		return false;
    }
	
	private void nomEndCake(World world, int x, int y, int z, EntityPlayer player)
    {
        if (player.canEat(false))
        {
            int l = world.getBlockMetadata(x, y, z) + 1;

            if (l >= 6)
            {
            	return;
            }
            else
            {
            	player.getFoodStats().addStats(2, 0.1F);
                world.setBlockMetadataWithNotify(x, y, z, l, 2);
                if (world.provider.dimensionId == 0)
                {
                	if (!BlockEndPortal.bossDefeated) player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
                	player.travelToDimension(1);
                }
            }
        }
    }
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hx, float hy, float hz, int meta)
    {
        return meta = 5;
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
    {
		if (world.provider.dimensionId == 1)
		{
			world.scheduleBlockUpdate(x, y, z, this.blockID, 12000);
		}
    }
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (world.provider.dimensionId == 1)
		{
			int meta = world.getBlockMetadata(x, y, z) - 1;
			if (meta > 0) world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			world.scheduleBlockUpdate(x, y, z, this.blockID, 12000);
		}
	}
}
