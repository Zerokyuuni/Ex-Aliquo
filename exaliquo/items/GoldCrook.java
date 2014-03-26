package exaliquo.items;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import exaliquo.data.ModIDs.Info;
import exnihilo.data.ModData;
import exnihilo.items.ItemCrook;

public class GoldCrook extends ItemCrook
{

	public GoldCrook(int id)
	{
		super(id, EnumToolMaterial.GOLD);
		this.setMaxDamage(this.getMaxDamage()/2-1);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "item.ExAliquo.GoldCrook";
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:CrookGold");
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		int blockID = world.getBlockId(X,Y,Z);
		int meta = world.getBlockMetadata(X, Y, Z);
		boolean validTarget = false;
		boolean extraDropped = false;

		Block block = Block.blocksList[blockID];

		if (block.isLeaves(null, 0, 0, 0))
		{
			if (!world.isRemote)
			{
				if (Loader.isModLoaded("Forestry"))
				{
					Class forestryLeafBlock = null;
					try {
						forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");

						Method dropStuff = null;
						if (forestryLeafBlock != null)
						{	
							dropStuff = forestryLeafBlock.cast(block).getClass().getDeclaredMethod("spawnLeafDrops", World.class, int.class, int.class, int.class, int.class, float.class, boolean.class);
							dropStuff.setAccessible(true);
						}

						if (dropStuff != null)
						{
							dropStuff.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
							dropStuff.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
							dropStuff.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
							extraDropped = true;
						}
					}
					catch (Exception ex){}
				}

				if (!extraDropped)
				{
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
				}

				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(75) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
				}
			}

			validTarget = true;
		}

		if (blockID == getIDs(Info.silkleaves))
		{
			if (!world.isRemote)
			{
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(12) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
					world.getWorldTime();
				}
			}

			validTarget = true;
		}

		if (validTarget)
		{
			//item.damageItem(3, player);

			if (item.stackSize == 0)
			{
				player.destroyCurrentEquippedItem();
			}
		}

		return false;
	}
}
