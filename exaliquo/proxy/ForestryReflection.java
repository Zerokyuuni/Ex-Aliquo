package exaliquo.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ForestryReflection
{
	public static boolean extras = false;
	public static boolean forestryrefcheck = true;
	private static Class forestryLeafBlock = null;
	private static Method drops = null;
	private static Object forestryLeafInstance = null;
	private static final Class[] spawnLeafParams = { World.class, int.class, int.class, int.class, int.class, float.class, boolean.class };

	public static void initProxy()
	{
		try
		{
			forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");
			
			if (forestryLeafBlock != null)
			{
				forestryLeafInstance = forestryLeafBlock.newInstance();
				drops = forestryLeafBlock.getDeclaredMethod("spawnLeafDrops", spawnLeafParams);
				drops.setAccessible(true);
				extras = true;
			}
		}
		catch (Exception e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
	}

	public static void ForestryLeaves(World world, Block block, int meta, int X, int Y, int Z)
	{
		if ((forestryLeafBlock != null) && (drops != null)) 
		{
			try
			{
				drops.invoke(forestryLeafInstance, world, X, Y, Z, meta, 1.0F, true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
