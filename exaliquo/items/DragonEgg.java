package exaliquo.items;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class DragonEgg extends Item
{
	
	public DragonEgg(int par1)
	{
		super(par1);
	}

	@Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if (world.provider.dimensionId == 1 && !world.isRemote)
		{
			if (!player.capabilities.isCreativeMode)
			{
				--itemstack.stackSize;
			}
			
			double rx = player.posX + ((Math.random()*67)-33);
			double ry = player.posY + ((Math.random()*51)-25);
			double rz = player.posZ + ((Math.random()*67)-33);
			
			Random rand = new Random();
			
			EntityDragon dragon = new EntityDragon(world);
			dragon.setLocationAndAngles(rx, ry, rz, rand.nextFloat(), 0.0F);
			//dragon.setLocationAndAngles(player.posX, player.posY, player.posZ, player.rotationYaw, 90.0F);
			//dragon.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 3));
			world.spawnEntityInWorld(dragon);
			
			return true;
		}
		return false;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 32;
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:DragonEgg");
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return "item.ExAliquo.DragonEgg";
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag)
	{
		list.add("Handle with care. Only usable in the End");
	}
}
