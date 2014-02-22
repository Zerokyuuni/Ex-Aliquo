package exaliquo;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

import thaumcraft.api.ThaumcraftApi;

import exaliquo.items.ThaumiumHammer;

public class Registries
{
	public static Item hammerThaum;
	
	public static void registerThaumItems() {
		hammerThaum = new ThaumiumHammer(Configurations.thaumHammer, ThaumcraftApi.toolMatThaumium).setUnlocalizedName("ExAliquo.ThaumHammer");
		GameRegistry.registerItem(hammerThaum, "ExAliquo.ThaumHammer");
	}
}
