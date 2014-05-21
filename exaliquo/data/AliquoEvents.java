package exaliquo.data;

import exaliquo.Registries;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.FakePlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class AliquoEvents
{

	@ForgeSubscribe
	public void onLivingDrops(LivingDropsEvent event)
	{
		if (event.entityLiving == null)
		{
			return;
		}
		
		if (event.entityLiving instanceof EntityDragon)
		{
			if (event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.source.getEntity();
				if (!player.worldObj.isRemote)
				{
					EntityItem item = new EntityItem(player.worldObj, player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, new ItemStack(Registries.dragonEgg, 1, 0));
		            player.worldObj.spawnEntityInWorld(item);
		            if (!(player instanceof FakePlayer))
		            {
		                item.onCollideWithPlayer(player);
		            }
				}
			}
		}
	}
}
