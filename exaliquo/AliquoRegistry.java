package exaliquo;

import java.util.Map;

import net.minecraft.item.EnumToolMaterial;

import com.google.common.collect.Maps;

public class AliquoRegistry {
	
	private static final Map<EnumToolMaterial, String>
	hammerTextures = Maps.newIdentityHashMap();
	
	/**
	 * Register a enum-wise preferred texture for materials.
	 */
	public static void registerHammerTexture(EnumToolMaterial toolMaterial, String texture) {
		hammerTextures.put(toolMaterial, texture);
	}
	
	public static String getHammerTexture(EnumToolMaterial toolMaterial) {
		return hammerTextures.get(toolMaterial);
	}
	

}
